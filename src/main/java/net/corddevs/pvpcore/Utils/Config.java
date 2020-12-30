package net.corddevs.pvpcore.Utils;
import java.util.ArrayList;
import java.util.UUID;

public class Config {
    public static String KitPvPKitName = "&f&lPVP";
    public static String KitSpecialKitName = "&d&lSPECIAL";
    public static String KitHeroKitName = "&6&lHERO";
    public static String KitZeusKitName = "&2&lZEUS";
    public static String KitEternalKitName = "&5&lETERNAL";
    public static String KitImmortalKitName = "&e&lIMMORTAL";
    public static String KitLegendKitName = "&3&lLEGEND";
    public static ArrayList<UUID> KitSpecialCooldownTime = new ArrayList<UUID>();
    public static ArrayList<UUID> KitHeroCooldownTime = new ArrayList<UUID>();
    public static ArrayList<UUID> KitZeusCooldownTime = new ArrayList<UUID>();
    public static ArrayList<UUID> KitEternalCooldownTime = new ArrayList<UUID>();
    public static ArrayList<UUID> KitImmortalCooldownTime = new ArrayList<UUID>();
    public static ArrayList<UUID> KitLegendCooldownTime = new ArrayList<UUID>();
    static int KitSpecialCooldownTimeSccondsInt = 10;
    static int KitHeroCooldownTimeSccondsInt = 10;
    static int KitZeusCooldownTimeSccondsInt = 10;
    static int KitEternalCooldownTimeSccondsInt = 10;
    static int KitImmortalCooldownTimeSccondsInt = 10;
    static int KitLegendCooldownTimeSccondsInt = 10;
    public static String HeroRankPermission = "rank.hero";
    public static String ZeusRankPermission = "rank.zeus";
    public static String EternalRankPermission = "rank.eternal";
    public static String ImmortalRankPermission = "rank.immortal";
    public static String LegendRankPermission = "rank.legend";
}