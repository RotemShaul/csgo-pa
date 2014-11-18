package com.rse.pa.csgo.utils


import scala.io.Source
import sys.process._
/**
 * Created by rotem on 13/11/14.
 */
object DemoParser {
  /**
   * This method receives the path for the demoutil executable, an input folder of demos,
   * and output folder for parsed demos.
   * @param execPath
   * @param execCommands
   * @param demoFilePath
   * @param outputPath
   */
    def runDemoUtil(execPath: String, execCommands: String,
                    demoFilePath : String, outputPath : String): Unit = {


      val outputFile = new java.io.File(outputPath)

      println(outputFile)

      val splitToPathAndName = demoFilePath splitAt (demoFilePath lastIndexOf "/");
      val demPath =  splitToPathAndName._1;
      val demFile = splitToPathAndName._2.drop(1);


      println((demPath +" " + demFile))


      val command = Process(s"${execPath}  ${execCommands} ${demFile}", new java.io.File(demPath)) ;

      println(command)

      val result =  command #> outputFile !


      println(result);
    }

  def printGameEventsKinds(gameEventsPath : String)  : Unit = {

      val begin_event_indicator = "{";
      val end_event_indicator ="}"

      val eventsSet = scala.collection.mutable.Set.empty[String]
      var isInEvent = false;
      val lines = Source.fromFile(gameEventsPath).getLines
      for( line <- lines) {
        if(!isInEvent && !line.equalsIgnoreCase(begin_event_indicator) && !line.equalsIgnoreCase(end_event_indicator)) {
          eventsSet.add(line)
        }
        if( line.equalsIgnoreCase(end_event_indicator)) {
          isInEvent = false;
        }
        if( line.equalsIgnoreCase(begin_event_indicator)) {
          isInEvent = true;
        }
      }

    println(eventsSet.filter(line => {
      !line.contains("disconnected")
    }))
    println(eventsSet.size)
  }

  def clearNetMessagesFile(netMessagesPath: String) : Unit = {

    val eventsSet = scala.collection.mutable.Set.empty[String]

    val eventsToClear = scala.collection.mutable.Set.empty[String]
    val begin_eventName_indicator = "----";
    val end_eventName_indicator ="-----------------"
    val clearedFile = new StringBuilder()
    Source.fromFile(netMessagesPath).getLines.foreach(line => {
      if(line.contains(begin_eventName_indicator)) {
        val clean = line.replaceAll("-", "");
        val split = clean.splitAt(clean.indexOf("("))._1
        eventsSet.add(split)
      }

    })

    println(eventsSet)
    println(eventsSet.size)
  }

  def clearFullMessagesFile(fulllMessagesPath: String) : Unit = {

    val eventsSet = scala.collection.mutable.Set.empty[String]

    val eventsToClear = scala.collection.mutable.Set.empty[String]
    val begin_eventName_indicator = "----";
    val end_eventName_indicator ="-----------------"
    val clearedFile = new StringBuilder()

    for( line <-Source.fromFile(fulllMessagesPath, "latin1").getLines) {
      if(line.contains(begin_eventName_indicator)) {
        val clean = line.replaceAll("-", "");
        val split = clean.splitAt(clean.indexOf("("))._1
        eventsSet.add(split)
      }

    }

    println(eventsSet)
    println(eventsSet.size)
  }

  def clearDataTablesFile(dataTablesPath: String) : Unit = {
    Source.fromFile(dataTablesPath).getLines.foreach(line => {
       if(!(line.contains("000")) && !line.contains("class")) println(line)
    })
  }
  //inferno_startburn     cs_win_panel_round    player_falldamage announce_phase_end  round_announce_match_point round_start

 /*
  rotem@rotem-UbuntuVM:~/csgo/demos$ ../demoinfogo-linux-master/demoinfogo -gameevents 190_titan_vs_team-ldlc_de_nuke_set1.dem > gameEvents190.txt
  rotem@rotem-UbuntuVM:~/csgo/demos$ ../demoinfogo-linux-master/demoinfogo -gameevents -nofootsteps 190_titan_vs_team-ldlc_de_nuke_set1.dem > gameEventsNoFootSteps190.txt
  rotem@rotem-UbuntuVM:~/csgo/demos$ ../demoinfogo-linux-master/demoinfogo -gameevents -nofootsteps -extrainfo 190_titan_vs_team-ldlc_de_nuke_set1.dem > gameEventsExtraInfo190.txt
  rotem@rotem-UbuntuVM:~/csgo/demos$ ../demoinfogo-linux-master/demoinfogo -deathcsv 190_titan_vs_team-ldlc_de_nuke_set1.dem > gameDeaths190.txt
  rotem@rotem-UbuntuVM:~/csgo/demos$ ../demoinfogo-linux-master/demoinfogo -deathcsv -nowarmup 190_titan_vs_team-ldlc_de_nuke_set1.dem > gameDeathsNowarmup190.txt
  rotem@rotem-UbuntuVM:~/csgo/demos$ ../demoinfogo-linux-master/demoinfogo -datatables 190_titan_vs_team-ldlc_de_nuke_set1.dem > datatables190.txt
  rotem@rotem-UbuntuVM:~/csgo/demos$ ../demoinfogo-linux-master/demoinfogo -stringtables 190_titan_vs_team-ldlc_de_nuke_set1.dem > stringtables190.txt
  rotem@rotem-UbuntuVM:~/csgo/demos$ ../demoinfogo-linux-master/demoinfogo -packetentites 190_titan_vs_team-ldlc_de_nuke_set1.dem > packetentites190.txt
  rotem@rotem-UbuntuVM:~/csgo/demos$ ../demoinfogo-linux-master/demoinfogo -netmessages 190_titan_vs_team-ldlc_de_nuke_set1.dem > netmessages190.txt
  rotem@rotem-UbuntuVM:~/csgo/demos$ ../demoinfogo-linux-master/demoinfogo 190_titan_vs_team-ldlc_de_nuke_set1.dem > full190.txt


   in string tables:
       player info
{
 updating:true
 xuid:76561197960710573
 name:LDLC NBK- * CMSTORM
 userID:175
 guid:STEAM_1:1:222422
 friendsID:444845
 friendsName:
 fakeplayer:0
 ishltv:0
 filesDownloaded:0
}

*/
}
