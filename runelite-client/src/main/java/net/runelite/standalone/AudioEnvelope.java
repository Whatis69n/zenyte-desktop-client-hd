package net.runelite.standalone;

import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cj")
public class AudioEnvelope {
   @ObfuscatedName("l")
   int form;
   @ObfuscatedName("r")
   int[] durations;
   @ObfuscatedName("e")
   int[] phases;
   @ObfuscatedName("w")
   int phaseIndex;
   @ObfuscatedName("q")
   int start;
   @ObfuscatedName("p")
   int max;
   @ObfuscatedName("b")
   int ticks;
   @ObfuscatedName("n")
   int step;
   @ObfuscatedName("c")
   int end;
   @ObfuscatedName("i")
   int amplitude;
   @ObfuscatedName("g")
   int segments;

   AudioEnvelope() {
      this.segments = 2;
      this.durations = new int[2];
      this.phases = new int[2];
      this.durations[0] = 0;
      this.durations[1] = 65535;
      this.phases[0] = 0;
      this.phases[1] = 65535;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lgl;)V"
   )
   final void method2168(Packet var1) {
      this.segments = var1.readUnsignedByte();
      this.durations = new int[this.segments];
      this.phases = new int[this.segments];

      for(int var2 = 0; var2 < this.segments; ++var2) {
         this.durations[var2] = var1.readUnsignedShort();
         this.phases[var2] = var1.readUnsignedShort();
      }

   }

   @ObfuscatedName("e")
   final void method2169() {
      this.ticks = 0;
      this.phaseIndex = 0;
      this.step = 0;
      this.amplitude = 0;
      this.max = 0;
   }

   @ObfuscatedName("q")
   final int method2170(int var1) {
      if(this.max >= this.ticks) {
         this.amplitude = this.phases[this.phaseIndex++] << 15;
         if(this.phaseIndex >= this.segments) {
            this.phaseIndex = this.segments - 1;
         }

         this.ticks = (int)((double)this.durations[this.phaseIndex] / 65536.0D * (double)var1);
         if(this.ticks > this.max) {
            this.step = ((this.phases[this.phaseIndex] << 15) - this.amplitude) / (this.ticks - this.max);
         }
      }

      this.amplitude += this.step;
      ++this.max;
      return this.amplitude - this.step >> 15;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lgl;)V"
   )
   final void method2171(Packet var1) {
      this.form = var1.readUnsignedByte();
      this.start = var1.readInt();
      this.end = var1.readInt();
      this.method2168(var1);
   }
}
