package com.rse.pa.csgo

import com.rse.pa.csgo.utils.DemoParser

/**
 * Hello world!
 *
 */
object App {
  def main(args : Array[String]): Unit = {
   // DemoParser.runDemoUtil("/home/rotem/csgo/demoinfogo-linux-master/demoinfogo", "-gameevents",
    //  "/home/rotem/csgo/demos/190_titan_vs_team-ldlc_de_nuke_set1.dem", "/home/rotem/csgo/demos/lala5.txt")

    //DemoParser.printGameEventsKinds("/home/rotem/csgo/demos/gameEventsExtraInfo190.txt")

    DemoParser.clearNetMessagesFile("/home/rotem/csgo/demos/netmessages190.txt")

    DemoParser.clearFullMessagesFile("/home/rotem/csgo/demos/full190.txt")

   // DemoParser.clearDataTablesFile("/home/rotem/csgo/demos/datatables190.txt")
  }
}
