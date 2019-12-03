@file:Suppress("RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")

import java.io.File

fun main(args: Array<String>) {
    var help: Boolean = false
    var name: String = ""
    var directory: String = ""
    for (i in 0 until (args.size)) {
        when {
            args[i] == "-h" -> help = true
            args[i] == "-n" -> name = args[i + 1]
            args[i] == "-d" -> directory = args[i + 1]
        }
    }
    if (directory == "" && name == "" && args.isNotEmpty()) {
        help = true
    }
    if (help) {
        println("HELP TO COMMAND directoryTreeToJSON")
        println("-h - help of command")
        println("-n - name of output file")
        println("-d - path to directory which parse to JSON")
    } else {
        if (name == "" && directory == "") {
            val listFoldersAndFiles = ListFoldersAndFiles()
            listFoldersAndFiles.checkFolder()
            println("SUCCESS")
        } else if (name != "") {
            if (directory != "") {
                val listFoldersAndFiles = ListFoldersAndFiles(File(directory), name)
                listFoldersAndFiles.checkFolder()
                println("SUCCESS")
            } else {
                val listFoldersAndFiles = ListFoldersAndFiles(name)
                listFoldersAndFiles.checkFolder()
                println("SUCCESS")
            }
        } else if (directory != "") {
            val listFoldersAndFiles = ListFoldersAndFiles(File(directory))
            listFoldersAndFiles.checkFolder()
            println("SUCCESS")
        }
    }
}

