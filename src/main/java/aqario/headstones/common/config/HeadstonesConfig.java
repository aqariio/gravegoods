package aqario.headstones.common.config;

import eu.midnightdust.lib.config.MidnightConfig;

public class HeadstonesConfig extends MidnightConfig {
    @Entry
    public static boolean enableGraves = true;
    @Entry
    public static boolean highlightGraves = false;
    @Entry
    public static boolean openOtherGraves = true;
}
