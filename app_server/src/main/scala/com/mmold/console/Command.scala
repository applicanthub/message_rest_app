package com.mmold

/**
 * The console command name.
 *
 * @author Nick Odumo Feb 2019
 */
trait Command {

  /**
   * The console command name.
   *
   */
  val name: String

  /**
   * The console command description.
   *
   */
  val description: String

  /**
   * Execute the console command.
   *
   * @param args Arguments as string
   */
  def handle(args: String): Unit

}
