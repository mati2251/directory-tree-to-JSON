import java.io.File

@Suppress("RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS", "NAME_SHADOWING")
class ListFoldersAndFiles (var folder: File){

    var howManyTabs = 0

    init{
        if(!folder.exists()){
            println("Error: Folder dose not exist")
            println("Set current path")
            folder = File(System.getProperty("user.dir"))
        }
        else if(folder.isFile){
            println("Error: Path is file")
            println("Set current path")
            folder = File(System.getProperty("user.dir"))
        }
    }

    constructor() : this(File(System.getProperty("user.dir"))) {}

    fun checkFolder(){
        checkFolder(folder)
    }

    private fun checkFolder(folder: File) {
        if (folder.isDirectory) {
            for (i in 0 until folder.listFiles().size) {
                for(i in 0..this.howManyTabs){
                    print("     ")
                }
                println(folder.listFiles()[i].name)
                this.howManyTabs++
                checkFolder(File(folder.listFiles()[i].path))
                this.howManyTabs--
            }
        }
    }
}