package com.example.batchprocessing.ItemReaders;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import org.apache.commons.io.comparator.NameFileComparator;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemStream;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

public class FilesInDirectoryItemReader implements ItemReader<File>, ItemStream {

    private File [] files;
    private int currentCount;
    private String key = "file.in.directory.count";

    public void setDirectory(String directory) {
        this.files = new File(directory).listFiles(
                (FileFilter) FileFilterUtils.fileFileFilter()
        );
        Arrays.sort(files, new NameFileComparator());
    }
    @Override
    public void open(ExecutionContext executionContext)
            throws ItemStreamException {
        currentCount = executionContext.getInt(key, 0);
    }
    @Override

    public File read() throws Exception, UnexpectedInputException,
            ParseException, NonTransientResourceException {
        int index = ++currentCount - 1;
        if(index == files.length) {
            return null;
        }
        System.out.println("read: " + files[index]);

        //force a failure
        if (index==2) {
            System.out.println("Throwing exception on index " + index);
            throw new Exception("Forced Failure");
        }

        return files[index];
    }

    @Override
    public void update(ExecutionContext executionContext)
            throws ItemStreamException {
        executionContext.putInt(key, currentCount);
    }

    @Override
    public void close() throws ItemStreamException { }
}
