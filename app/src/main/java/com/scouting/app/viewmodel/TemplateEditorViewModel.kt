package com.scouting.app.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.TextFieldValue
import androidx.core.net.toUri
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.scouting.app.MainActivity
import com.scouting.app.misc.FilePaths
import com.scouting.app.model.TemplateFormatMatch
import com.scouting.app.model.TemplateFormatPit
import com.scouting.app.model.TemplateItem
import com.scouting.app.model.TemplateTypes
import java.io.File
import java.util.UUID

class TemplateEditorViewModel : ViewModel() {

    var currentTemplateType = "match"
    var finalFileName by mutableStateOf(TextFieldValue())

    // Triple consists of saveKey, itemType and itemID
    var saveKeyList = mutableStateListOf<Triple<String, TemplateTypes, String>>()
    var autoListItems = mutableStateListOf<TemplateItem>()
    var teleListItems = mutableStateListOf<TemplateItem>()
    var pitListItems = mutableStateListOf<TemplateItem>()

    var showingEditDialog by mutableStateOf(false)
    var currentListResource by mutableStateOf(pitListItems)
    var currentEditItemIndex by mutableStateOf(0)

    fun writeTemplateToFile(context: MainActivity) {
        val outputFile = File(FilePaths.TEMPLATE_DIRECTORY, processFinalFileName())
        val template: Any = if (currentTemplateType == "match") {
            TemplateFormatMatch(
                title = processFinalFileName(),
                autoTemplateItems = autoListItems,
                teleTemplateItems = teleListItems,
                saveOrderByKey = createExportedSaveKeyList()
            )
        } else {
            TemplateFormatPit(
                title = processFinalFileName(),
                templateItems = pitListItems
            )
        }
        outputFile.createNewFile()
        context.contentResolver.openOutputStream(outputFile.toUri())?.use {
            it.write(Gson().toJson(template).toByteArray())
            it.close()
        }
        resetInstanceData()
    }

    fun createSaveKeyList() {
        saveKeyList.clear()
        val listResources = listOf(autoListItems, teleListItems)
        listResources.forEach { list ->
            list.forEach {
                saveKeyList.add(Triple(it.saveKey, it.type, it.id))
                if (it.type == TemplateTypes.TRI_SCORING) {
                    saveKeyList.add(Triple(it.saveKey2.toString(), it.type, UUID.randomUUID().toString()))
                    saveKeyList.add(Triple(it.saveKey3.toString(), it.type, UUID.randomUUID().toString()))
                }
            }
        }
    }

    private fun createExportedSaveKeyList() : List<String> {
        val exportedSaveKeyList = mutableListOf<String>()
        saveKeyList.forEach { triple ->
            exportedSaveKeyList.add(triple.first)
        }
        return exportedSaveKeyList
    }

    private fun processFinalFileName() : String {
        return finalFileName.text.let {
            if (it.contains(".json")) it else "$it.json"
        }
    }

    fun resetInstanceData() {
        saveKeyList.clear()
        autoListItems.clear()
        teleListItems.clear()
        pitListItems.clear()
        finalFileName = TextFieldValue()
    }

}