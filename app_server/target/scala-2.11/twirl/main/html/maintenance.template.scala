
package html

import play.twirl.api._
import play.twirl.api.TemplateMagic._



/**/
object maintenance extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.1*/("""<!doctype html>
<!--[if lt IE 7]> <html class="no-js ie6 oldie" lang="en"> <![endif]-->
<!--[if IE 7]> <html class="no-js ie7 oldie" lang="en"> <![endif]-->
<!--[if IE 8]> <html class="no-js ie8 oldie" lang="en"> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js" lang="en">
<!--<![endif]-->
<head>
    <meta charset="utf-8">
    <!-- Load chromeframe -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>Page Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/app.css">
    <!-- rename this to fit your naming conventions -->
    <!-- Load modernizr -->
    <script src="js/modernizr.js"></script>
</head>
<body>
<div class="container-fluid">
    <!-- content here -->
</div>
<!-- Borrowed from HTML5 Boilerplate -->
<script src="//ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script>
        window.jQuery || document.write('<script src="js/jquery.js"><\/script>')
</script>
<!-- End Boilerplate -->
<script src="js/bootstrap.js"></script>
<script src="js/app.js"></script>
<!-- Google Analytics -->
<script>
        var _gaq = [
            ['_setAccount', 'UA-XXXXX-X'],
            ['_trackPageview']
        ];
        (function(d, t) """),format.raw/*38.25*/("""{"""),format.raw/*38.26*/("""
            """),format.raw/*39.13*/("""var g = d.createElement(t),
                s = d.getElementsByTagName(t)[0];
            g.src = ('https:' == location.protocol ? '//ssl' : '//www') + '.google-analytics.com/ga.js';
            s.parentNode.insertBefore(g, s)
        """),format.raw/*43.9*/("""}"""),format.raw/*43.10*/("""(document, 'script'));
    </script>
</body>

</html>"""))}
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Sun Jan 20 18:05:17 EST 2019
                  SOURCE: /home/nick/Documents/projects/scala/scala-finch-finagle-example/src/main/twirl/maintenance.scala.html
                  HASH: 6118907b420c69cd6d691dd14e1835ba60bfbb5b
                  MATRIX: 418->0|1769->1323|1798->1324|1839->1337|2101->1572|2130->1573
                  LINES: 16->1|53->38|53->38|54->39|58->43|58->43
                  -- GENERATED --
              */
          