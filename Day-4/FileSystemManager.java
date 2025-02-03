import java.util.*;

class FileSystem {
    private Directory root;
    private Directory currentDirectory;

    public FileSystem() {
        root = new Directory("root", null);
        currentDirectory = root;
    }

    public void mkdir(String name) {
        if (currentDirectory.hasChild(name)) {
            System.out.println("Error: Directory already exists.");
            return;
        }
        currentDirectory.addDirectory(new Directory(name, currentDirectory));
    }

    public void touch(String name) {
        if (currentDirectory.hasChild(name)) {
            System.out.println("Error: File already exists.");
            return;
        }
        currentDirectory.addFile(new File(name));
    }

    public void cd(String name) {
        if (name.equals("..")) {
            if (currentDirectory.getParent() != null) {
                currentDirectory = currentDirectory.getParent();
            }
        } else {
            Directory dir = currentDirectory.getSubDirectory(name);
            if (dir != null) {
                currentDirectory = dir;
            } else {
                System.out.println("Error: Directory not found.");
            }
        }
    }

    public void ls() {
        currentDirectory.listContents();
    }

    public void rm(String name) {
        if (!currentDirectory.remove(name)) {
            System.out.println("Error: File or Directory not found.");
        }
    }

    public void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void exit() {
        System.out.println("Exiting file system manager...");
        System.exit(0);
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print(currentDirectory.getPath() + " > ");
            String[] input = scanner.nextLine().split(" ");
            if (input.length == 0) continue;
            String command = input[0];
            switch (command) {
                case "mkdir":
                    if (input.length > 1) mkdir(input[1]);
                    else System.out.println("Usage: mkdir [directory_name]");
                    break;
                case "touch":
                    if (input.length > 1) touch(input[1]);
                    else System.out.println("Usage: touch [file_name]");
                    break;
                case "cd":
                    if (input.length > 1) cd(input[1]);
                    else System.out.println("Usage: cd [directory_name]");
                    break;
                case "ls":
                    ls();
                    break;
                case "rm":
                    if (input.length > 1) rm(input[1]);
                    else System.out.println("Usage: rm [file_name]");
                    break;
                case "clear":
                    clear();
                    break;
                case "exit":
                    exit();
                    break;
                case "help":
                    System.out.println("Available commands: ");
                    System.out.println("mkdir\ntouch\ncd\nls\nrm\nclear\nexit");
                    break;
                default:
                    System.out.println("Unknown command: " + command);
            }
        }
    }
}

class File {
    private String name;
    public File(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}

class Directory {
    private String name;
    private Directory parent;
    private List<Directory> subDirectories;
    private List<File> files;

    public Directory(String name, Directory parent) {
        this.name = name;
        this.parent = parent;
        this.subDirectories = new ArrayList<>();
        this.files = new ArrayList<>();
    }

    public void addDirectory(Directory dir) {
        subDirectories.add(dir);
    }

    public void addFile(File file) {
        files.add(file);
    }

    public boolean hasChild(String name) {
        return getSubDirectory(name) != null || getFile(name) != null;
    }

    public Directory getSubDirectory(String name) {
        for (Directory dir : subDirectories) {
            if (dir.name.equals(name)) {
                return dir;
            }
        }
        return null;
    }

    public File getFile(String name) {
        for (File file : files) {
            if (file.getName().equals(name)) {
                return file;
            }
        }
        return null;
    }

    public boolean remove(String name) {
        return subDirectories.removeIf(dir -> dir.name.equals(name)) || files.removeIf(file -> file.getName().equals(name));
    }

    public void listContents() {
        for (Directory dir : subDirectories) {
            System.out.println("[DIR] " + dir.name);
        }
        for (File file : files) {
            System.out.println("[FILE] " + file.getName());
        }
    }

    public String getPath() {
        return (parent == null) ? "/" : parent.getPath() + name + "/";
    }

    public Directory getParent() {
        return parent;
    }
}

public class FileSystemManager {
    public static void main(String[] args) {
        FileSystem fs = new FileSystem();
        fs.run();
    }
}
