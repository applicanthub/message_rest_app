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
   * @author Nick Odumo Feb 2019
   */
  val name: String

  /**
   * The console command description.
   *
   * @author Nick Odumo Feb 2019
   */
  val description: String

  /**
   * Execute the console command.
   *
   * @author Nick Odumo Feb 2019
   * @param args Arguments as string
   */
  def handle(args: String): Unit

}
