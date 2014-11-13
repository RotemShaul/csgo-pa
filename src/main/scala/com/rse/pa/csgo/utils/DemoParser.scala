package com.rse.pa.csgo.utils

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

      val command = execPath + " " + execCommands + " " + demoFilePath

      println(command)

      val result =  command !

      println(result);
    }
}
