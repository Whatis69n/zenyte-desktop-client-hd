package net.runelite.client.standalone;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gi")
public class class194 {
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      longValue = -4800651462629328071L
   )
   static long field1848;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      longValue = -8064578899792517985L
   )
   static long field1846;

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-1561003737"
   )
   static void method3303(byte[] var0) {
      Buffer var1 = new Buffer(var0);
      var1.field1073 = var0.length - 2;
      class112.field1056 = var1.readUnsignedShort();
      class120.field1149 = new int[class112.field1056];
      class112.field1055 = new int[class112.field1056];
      class112.field1052 = new int[class112.field1056];
      class167.field1544 = new int[class112.field1056];
      class161.field1507 = new byte[class112.field1056][];
      var1.field1073 = var0.length - 7 - class112.field1056 * 8;
      class112.field1057 = var1.readUnsignedShort();
      class112.field1054 = var1.readUnsignedShort();
      int var2 = (var1.readUnsignedByte() & 255) + 1;

      int var3;
      for(var3 = 0; var3 < class112.field1056; ++var3) {
         class120.field1149[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class112.field1056; ++var3) {
         class112.field1055[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class112.field1056; ++var3) {
         class112.field1052[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class112.field1056; ++var3) {
         class167.field1544[var3] = var1.readUnsignedShort();
      }

      var1.field1073 = var0.length - 7 - class112.field1056 * 8 - (var2 - 1) * 3;
      class192.field1841 = new int[var2];

      for(var3 = 1; var3 < var2; ++var3) {
         class192.field1841[var3] = var1.method1909();
         if(class192.field1841[var3] == 0) {
            class192.field1841[var3] = 1;
         }
      }

      var1.field1073 = 0;

      for(var3 = 0; var3 < class112.field1056; ++var3) {
         int var4 = class112.field1052[var3];
         int var5 = class167.field1544[var3];
         int var6 = var4 * var5;
         byte[] var7 = new byte[var6];
         class161.field1507[var3] = var7;
         int var8 = var1.readUnsignedByte();
         int var9;
         if(var8 == 0) {
            for(var9 = 0; var9 < var6; ++var9) {
               var7[var9] = var1.method1906();
            }
         } else if(var8 == 1) {
            for(var9 = 0; var9 < var4; ++var9) {
               for(int var10 = 0; var10 < var5; ++var10) {
                  var7[var9 + var4 * var10] = var1.method1906();
               }
            }
         }
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "([BIIIIIIILdh;[Lfr;I)V",
      garbageValue = "1846703706"
   )
   static final void method3302(byte[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, class312 var8, class182[] var9) {
      Buffer var10 = new Buffer(var0);
      int var11 = -1;

      while(true) {
         int var12 = var10.method1964();
         if(var12 == 0) {
            return;
         }

         var11 += var12;
         int var13 = 0;

         while(true) {
            int var14 = var10.readSmart();
            if(var14 == 0) {
               break;
            }

            var13 += var14 - 1;
            int var15 = var13 & 63;
            int var16 = var13 >> 6 & 63;
            int var17 = var13 >> 12;
            int var18 = var10.readUnsignedByte();
            int var19 = var18 >> 2;
            int var20 = var18 & 3;
            if(var17 == var4 && var16 >= var5 && var16 < var5 + 8 && var15 >= var6 && var15 < var6 + 8) {
               class172 var21 = class152.method2696(var11);
               int var22 = var2 + class9.method110(var16 & 7, var15 & 7, var7, var21.field1592, var21.field1635, var20);
               int var23 = var3 + class322.method5708(var16 & 7, var15 & 7, var7, var21.field1592, var21.field1635, var20);
               if(var22 > 0 && var23 > 0 && var22 < 103 && var23 < 103) {
                  int var24 = var1;
                  if((class31.field239[1][var22][var23] & 2) == 2) {
                     var24 = var1 - 1;
                  }

                  class182 var25 = null;
                  if(var24 >= 0) {
                     var25 = var9[var24];
                  }

                  class284.method5032(var1, var22, var23, var11, var20 + var7 & 3, var19, var8, var25);
               }
            }
         }
      }
   }
}
