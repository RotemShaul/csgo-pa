package com.rse.pa.csgo

import com.rse.pa.csgo.utils.DemoParser

/**
 * Hello world!
 *
 */
object App {
  def main(args : Array[String]): Unit = {
    DemoParser.runDemoUtil("/home/rotem/csgo/demoinfogo-linux-master/demoinfogo", "-gameevents",
      "/home/rotem/csgo/demos/190_titan_vs_team-ldlc_de_nuke_set1.dem", "")
  }
}
