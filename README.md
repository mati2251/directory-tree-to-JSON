# Directory tree to JSON
That is command use to print tree directory to JSON file.
## How to use it?
[Link to download](https://github.com/mati2251/directory-tree-to-JSON/releases)<br>
`java -jar directoryTreeToJSON.jar`<br>
Default command print current directory and save to file out.json<br>
`java -jar directoryTreeToJSON.jar -d /bin`<br>
If you add parameter **-d** you will indicate directory to analyse<br>
`java -jar directoryTreeToJSON.jar -n /bin`<br>
If you add parameter **-n** you will change name output file (command self add extension json)<br>
`java -jar directoryTreeToJSON.jar -h`<br>
If you need help use parameter **-h**<br>
If you need shorter version this command you can use e. g. in linux alias or sh file
##Effect
```json5
{
  "out.json": { 
    "type": "file", 
    "files": {} 
  },
  "folder1": { 
    "type": "folder", 
    "files": {
      "file3": { 
        "type": "file", 
        "files": {} 
      },
      "file4": { 
        "type": "file", 
        "files": {} 
      },
      "file2": { 
        "type": "file", 
        "files": {} 
      },
      "file1": { 
        "type": "file", 
        "files": {} 
      },
      "file5": { 
        "type": "file", 
        "files": {} 
      }
    } 
  },
  "file6": { 
    "type": "file", 
    "files": {} 
  },
  "folder3": { 
    "type": "folder", 
    "files": {
      "file8": { 
        "type": "file", 
        "files": {} 
      },
      "file7": { 
        "type": "file", 
        "files": {} 
      }
    } 
  },
  "folder2": { 
    "type": "folder", 
    "files": {} 
  },
  "folder4": { 
    "type": "folder", 
    "files": {} 
  }
}
```
## License 
**GNU General Public License v3.0**