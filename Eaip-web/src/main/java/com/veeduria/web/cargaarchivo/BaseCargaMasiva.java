/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veeduria.web.cargaarchivo;

import com.veeduria.adm.BaseEjbSLBean;
import com.veeduria.sys.dao.SysRegistrocarga;
import java.io.IOException;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author luz
 */
public class BaseCargaMasiva extends BaseEjbSLBean {

    protected SysRegistrocarga sysRegistrocarga;

    public SysRegistrocarga getSysRegistrocarga() {
        return sysRegistrocarga;
    }

    public void setSysRegistrocarga(SysRegistrocarga sysRegistrocarga) {
        this.sysRegistrocarga = sysRegistrocarga;
    }

    private FileSystem createZipFileSystem(String zipFilename,
            boolean create)
            throws IOException {
        // convert the filename to a URI
        final Path path = Paths.get(zipFilename);
        final URI uri = URI.create("jar:file:" + path.toUri().getPath());

        final Map<String, String> env = new HashMap<>();
        if (create) {
            env.put("create", "true");
        }
        return FileSystems.newFileSystem(uri, env);
    }

    public void unzip(String zipFilename, String destDirname)
            throws IOException {

        final Path destDir = Paths.get(destDirname);
        //Si la carpeta de destino no existe, crearla
        if (Files.notExists(destDir)) {
            System.out.println(destDir + " does not exist. Creating...");
            Files.createDirectories(destDir);
        }

        try (FileSystem zipFileSystem = createZipFileSystem(zipFilename, false)) {
            final Path root = zipFileSystem.getPath("/");

            //Recorrer zip y crear archivos en destino
            Files.walkFileTree(root, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file,
                        BasicFileAttributes attrs) throws IOException {
                    final Path destFile = Paths.get(destDir.toString(),
                            file.toString());
                    System.out.printf("Extrayendo %s a %s\n", file, destFile);
                    Files.copy(file, destFile, StandardCopyOption.REPLACE_EXISTING);
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult preVisitDirectory(Path dir,
                        BasicFileAttributes attrs) throws IOException {
                    final Path dirToCreate = Paths.get(destDir.toString(),
                            dir.toString());
                    if (Files.notExists(dirToCreate)) {
                        System.out.printf("Creando carpeta %s\n", dirToCreate);
                        Files.createDirectory(dirToCreate);
                    }
                    return FileVisitResult.CONTINUE;
                }
            });
        }
    }
}
