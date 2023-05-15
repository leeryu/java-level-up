package com.leeeryu.programs;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Cleaner {

    private DateValidator validator;

    public Cleaner() {
        validator = new DateValidatorUsingDateFormat("yyyyMMdd");
    }

    public void setValidator(DateValidator validator) {
        this.validator = validator;
    }

    public DateValidator getValidator() {
        return validator;
    }

    public static void main(String[] args) {
        final Cleaner cleaner = new Cleaner();
        final List<File> ignoredFiles = new ArrayList<>();
        final File resources = new File("C:\\Sources\\Data");

        final File[] files = resources
                .listFiles(File::isFile);

        for (File f : files != null ? files : new File[0]) {
            String[] fileNames = f.getName().split("_");
            if (fileNames.length < 2) {
                ignoredFiles.add(f);
                continue;
            }

            String fileName = fileNames[1];
            if (fileName.length() < 8) {
                ignoredFiles.add(f);
                continue;
            }

            cleaner.setValidator((date) -> {
                try {
                    final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                    sdf.setLenient(false);
                    sdf.parse(date);
                } catch (Exception ignored) {
                    return false;
                }
                return true;
            });

            if (!cleaner.getValidator().isValid(fileName)) {
                ignoredFiles.add(f);
                continue;
            }

            String directoryName = fileName.substring(0, 6);

            final boolean isDirectory = Files.isDirectory(new File(resources, directoryName).toPath());

            if (!isDirectory) {
                try {
                    final Path directory = Files.createDirectory(
                            new File(resources, directoryName).toPath());
                    Files.move(f.toPath(), directory.resolve(f.getName()));
                } catch (IOException e) {
                    ignoredFiles.add(f);
                    System.out.println("Ignored: " + f.getName());
                }
            }
        }

        System.out.println("Ignored files: " + ignoredFiles);
    }

    interface DateValidator {
        boolean isValid(String date);
    }

    public class DateValidatorUsingDateFormat implements DateValidator {
        private String dateFormat;

        public DateValidatorUsingDateFormat(String dateFormat) {
            this.dateFormat = dateFormat;
        }

        @Override
        public boolean isValid(String date) {
            try {
                final SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
                sdf.setLenient(false);
                sdf.parse(date);
            } catch (Exception e) {
                return false;
            }

            return true;
        }
    }
}
