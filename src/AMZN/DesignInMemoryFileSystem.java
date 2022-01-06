package AMZN;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class DesignInMemoryFileSystem {

    class FileSystem {
        private FileNode root;

        public FileSystem() {
            root = new FileNode("");
        }

        public List<String> ls(String path) {
            return findNode(path).getList();
        }

        public void mkdir(String path) {
            findNode(path);
        }

        public void addContent(String filePath, String content) {
            findNode(filePath).addContent(content);
        }

        public String readContentFromFile(String filePath) {
            return findNode(filePath).getContent();
        }

        private FileNode findNode(String path) {
            String[] files = path.split("/");
            FileNode current = root;
            for (String file : files) {
                if (file.length() == 0)
                    continue;
                current.children.putIfAbsent(file, new FileNode(file));
                current = current.children.get(file);
                if (current.isFile())
                    break;
            }
            return current;
        }

    }

    private class FileNode {
        private TreeMap<String, FileNode> children;
        private StringBuilder file;
        private String name;

        public FileNode(String name) {
            children = new TreeMap<>();
            file = new StringBuilder();
            this.name = name;
        }

        public String getContent() {
            return file.toString();
        }

        public String getName() {
            return name;
        }

        public void addContent(String content) {
            file.append(content);
        }

        public boolean isFile() {
            return file.length() > 0;
        }

        public List<String> getList() {
            List<String> list = new ArrayList<>();
            if (isFile())
                list.add(getName());
            else
                list.addAll(children.keySet());
            return list;
        }
    }

}
