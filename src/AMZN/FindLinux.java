package AMZN;

import java.util.ArrayList;
import java.util.List;

/*
implemnet linux find command as an api ,the api willl support finding
files that has given size requirements and a file with a certain format like

find all file >5mb
find all xml
Assume file class
{
get name()
directorylistfile()
getFile()
create a library flexible that is flexible
Design clases,interfaces.
 */
public class FindLinux {

    class File {
        String name;
        int size;
        int type;
        boolean isDirectory;
        File[] children;
    }

    abstract class Filter {
        abstract boolean apply(File file);
    }

    class MinSizeFilter extends Filter {

        int minSize;

        public MinSizeFilter(int minSize) {
            this.minSize = minSize;
        }

        @Override
        boolean apply(File file) {
            return file.size > minSize;
        }
    }

    class TypeFilter extends Filter {

        int type;

        public TypeFilter(int type) {
            this.type = type;
        }

        @Override
        boolean apply(File file) {
            return file.type == type;
        }
    }

    class FindCommand {

        public List<File> findWithFilters(File directory, List<Filter> filters) {
            if (!directory.isDirectory) {
                //return new NotADirectoryException();
            }
            List<File> output = new ArrayList<>();
            findWithFilters(directory, filters, output);
            return output;
        }

        private void findWithFilters(File directory, List<Filter> filters, List<File> output) {
            if (directory.children == null) {
                return;
            }
            for (File file : directory.children) {
                if (file.isDirectory) {
                    findWithFilters(file, filters, output);
                } else {
                    boolean selectFile = true;
                    for (Filter filter : filters) {
                        if (!filter.apply(file)) {
                            selectFile = false;
                        }
                    }
                    if (selectFile) {
                        output.add(file);
                    }
                }
            }
        }
    }
}
