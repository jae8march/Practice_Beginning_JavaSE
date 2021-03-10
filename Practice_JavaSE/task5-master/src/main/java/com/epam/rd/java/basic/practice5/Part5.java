package com.epam.rd.java.basic.practice5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Task 5.
 */
public class Part5 implements Callable<Object> {

    private static final Object MONITOR = new Object();
    private static final String FILE = "part5.txt";
    private static final int NUMBER_OF_THREADS = 10;
    private static final int REPEAT = 20;

    private final RandomAccessFile raf;
    private final int counter;
    private final String moreChars;

    public Part5(RandomAccessFile raf, int counter, String otherChar, int stringLength) {
        this.raf = raf;
        this.counter = counter;

        StringBuilder sb = new StringBuilder(stringLength);
        for (int i = 0; i < REPEAT; i++) {
            sb.append(otherChar);
        }
        sb.append(System.lineSeparator());
        moreChars = sb.toString();
    }

    public static void main(String[] args) {
        File file = isExist();

        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile(file, "rw");
        } catch (FileNotFoundException e) {
            //catch-block
        }
        ExecutorService exe = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
        try {
            ArrayList<Future> futures = new ArrayList<>();

            int position = 0;
            for (int currentNumber = 0; currentNumber < NUMBER_OF_THREADS; currentNumber++) {
                String charToFill = String.valueOf(currentNumber);
                int charsLength = REPEAT * charToFill.length();
                int stringLength = charsLength + System.lineSeparator().length();

                Future f = exe.submit(new Part5(raf, position, charToFill, stringLength));
                futures.add(f);
                position += stringLength;
            }
            someLikeIterator(futures);
        } finally {
            exe.shutdown();
            try {
                Objects.requireNonNull(raf).close();
                System.out.print(new String(Files.readAllBytes(file.toPath())));
            } catch (IOException e) {
                //catch-block
            }
        }
    }

    public static void someLikeIterator(List<Future> f) {
        for (Future fu : f) {
            try {
                fu.get();
            } catch (InterruptedException e) {
                System.err.println(e);
                Thread.currentThread().interrupt();
            } catch (ExecutionException ex) {
                System.err.println(ex);
                Thread.currentThread().interrupt();
            }
        }
    }

    public static File isExist() {
        return new File(FILE);
    }

    @Override
    public Object call() {
        RandomAccessFile r = getRaf();
        synchronized (MONITOR) {
            try {
                r.seek(counter);
                r.write(moreChars.getBytes());
            } catch (IOException e) {
                //catch-block
            }
        }
        return null;
    }

    private RandomAccessFile getRaf() {
        return raf;
    }
}
