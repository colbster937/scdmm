package dev.colbster937.scdmm;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class SCDMMJavaAgent {
  public static final Path BASE_PATH = Paths.get("mods", "scdmm");

  public static void premain(final String args) {
    final List<String> addMods = new ArrayList<>(SCDMMOSUtil.getModDirs());

    for (int i = 0, l = addMods.size(); i < l; i++) {
      final Path path = BASE_PATH.resolve(addMods.get(i)).toAbsolutePath().normalize();
      addMods.set(i, path.toString());

      try {
        Files.createDirectories(path);
      } catch (final IOException ex) {
        throw new RuntimeException(ex);
      }
    }

    final String prop = System.getProperty("fabric.addMods");
    if (prop != null) {
      addMods.addAll(0, Arrays.asList(prop.split(File.pathSeparator)));
    }

    System.setProperty("fabric.addMods", String.join(File.pathSeparator, addMods));

    System.out.println(System.getProperty("fabric.addMods"));
  }
}
