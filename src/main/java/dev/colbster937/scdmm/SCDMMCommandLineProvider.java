package dev.colbster937.scdmm;

import java.io.File;
import java.net.URISyntaxException;
import java.util.List;

import com.juanmuscaria.relauncher.CommandLineProvider;

public final class SCDMMCommandLineProvider implements CommandLineProvider {
  @Override
  public List<String> extraJvmArguments() {
    try {
      final String jar = new File(SCDMMJavaAgent.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getAbsolutePath();
      return List.of("-javaagent:" + jar);
    } catch (final URISyntaxException ex) {
      throw new RuntimeException(ex);
    }
  }
}
