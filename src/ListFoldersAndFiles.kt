import java.io.File

@Suppress("RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS", "NAME_SHADOWING")
class ListFoldersAndFiles(var folder: File, fileName: String) {

    var howManyTabs = 0
    var file = File("$fileName.json")

    init {
        if (!folder.exists()) {
            println("Error: Folder dose not exist")
            println("Set current path")
            folder = File(System.getProperty("user.dir"))
        } else if (folder.isFile) {
            println("Error: Path is file")
            println("Set current path")
            folder = File(System.getProperty("user.dir"))
        }
    }

    constructor() : this(File(System.getProperty("user.dir")), "out") {}
    constructor(folder: File) : this(folder, "out") {}
    constructor(fileName: String) : this(File(System.getProperty("user.dir")), fileName) {}


    fun checkFolder() {
        file.printWriter().use { out -> out.println("{") }
        checkFolder(folder)
        file.appendText("}")
    }

    private fun addTabsToFile(howManyTabs: Int) {
        for (i in 0..howManyTabs) {
            file.appendText("  ")
        }
    }

    private fun checkFolder(folder: File) {
        if (folder.isDirectory) {
            for (i in 0 until folder.listFiles().size) {
                addTabsToFile(this.howManyTabs)
                file.appendText("\"${folder.listFiles()[i].name}\": { \n")
                addTabsToFile(this.howManyTabs + 1)
                file.appendText("\"type\": ")
                if (folder.listFiles()[i].isDirectory)
                    file.appendText("\"folder\", \n")
                else
                    file.appendText("\"file\", \n")
                addTabsToFile(this.howManyTabs + 1)
                file.appendText("\"files\": {")
                if (folder.listFiles()[i].isDirectory) {
                    if (folder.listFiles()[i].listFiles().isNotEmpty()) {
                        file.appendText("\n")
                        howManyTabs++
                    }
                }
                this.howManyTabs++
                checkFolder(File(folder.listFiles()[i].path))
                this.howManyTabs--
                if (folder.listFiles()[i].isDirectory) {
                    if (folder.listFiles()[i].listFiles().isNotEmpty()) {
                        howManyTabs--
                        addTabsToFile(this.howManyTabs + 1)
                    }
                }
                file.appendText("} \n")
                addTabsToFile(this.howManyTabs)
                file.appendText("}")
                if (folder.listFiles().size - 1 != i) {
                    file.appendText(",")
                }
                file.appendText("\n")
            }
        }
    }
}