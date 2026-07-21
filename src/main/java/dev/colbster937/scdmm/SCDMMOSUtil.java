package dev.colbster937.scdmm;

import java.util.ArrayList;
import java.util.List;

public enum SCDMMOSUtil {
  WINDOWS(true, false, "win"),
  LINUX(true, false, "linux", "gnu"),
  MACOS(true, false, "mac", "darwin"),
  IOS(false, true, "ios"),
  ANDROID(false, true, "android", "dalvik"),
  UNKNOWN(false, false);

  private static final List<String> MOBILE_CLASSES = List.of("net.kdt.pojavlaunch.Tools");

  private final boolean desktop;
  private final boolean mobile;
  private final String[] terms;

  private SCDMMOSUtil(final boolean desktop, final boolean mobile, final String ...terms) {
    this.desktop = desktop;
    this.mobile = mobile;
    this.terms = terms;
  }

  private List<String> _getModDirs() {
    final List<String> ret = new ArrayList<>();

    ret.add("common");

    ret.add(this.name().toLowerCase());

    if (this.desktop) {
      ret.add("desktop");
    }

    if (this.mobile) {
      ret.add("mobile");
    }

    return ret;
  }

  private static SCDMMOSUtil getOS() {
    final String info = String.join(" ",
      System.getProperty("os.name", ""),
      System.getProperty("java.vm.name", ""),
      System.getProperty("java.runtime.name", ""),
      String.join(" ", System.getenv().keySet())
    ).toLowerCase();

    boolean mobile = false;

    final ClassLoader loader = SCDMMOSUtil.class.getClassLoader();
    for (final String clazz : MOBILE_CLASSES) {
      try {
        Class.forName(clazz, false, loader);
        mobile = true;
        break;
      } catch (final ClassNotFoundException ex) {}
    }

    SCDMMOSUtil ret = UNKNOWN;
    int score = 0;

    for (final SCDMMOSUtil os : values()) {
      int _score = 0;

      for (String term : os.terms) {
        if (info.contains(term)) {
          _score += 2;
        }
      }

      if (os.mobile && mobile) {
        _score++;
      }

      if (_score > score) {
        ret = os;
        score = _score;
      }
    }

    return ret;
  }

  public static List<String> getModDirs() {
    return getOS()._getModDirs();
  }
}
