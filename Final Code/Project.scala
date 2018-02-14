import org.apache.spark.SparkContext
import org.apache.spark.SparkConf
import org.apache.spark.mllib.classification.{LogisticRegressionWithLBFGS, LogisticRegressionModel}
import org.apache.spark.mllib.regression.LabeledPoint
import org.apache.spark.mllib.linalg.{Vector, Vectors}
import scala.swing._
import scala.swing.event.ButtonClicked
import java.awt.font
import java.awt.image.BufferedImage                                           
import java.io.File                                                           
import javax.imageio.ImageIO 
import javax.swing.{ImageIcon, JFrame, JLabel, JPanel}


  
  class UI extends MainFrame{
    
    preferredSize = new Dimension(1000, 1000)
    var total_value = ""
    title = "Bully result"
    val l1 = new Label{text = "Breakfast during weekdays" 
                       font = new Font("Ariel", java.awt.Font.BOLD, 24)}
    val l2 = new Label{text = "Breakfast during weekends"
                      font = new Font("Ariel", java.awt.Font.BOLD, 24)}
    val l3 = new Label{text = "How often do you eat fruits"
                      font = new Font("Ariel", java.awt.Font.BOLD, 24)}
    val l4 = new Label{text = "How often do you eat vegetables"
                      font = new Font("Ariel", java.awt.Font.BOLD, 24)}
    val l5 = new Label{text = "How often do you eat sweets"
                      font = new Font("Ariel", java.awt.Font.BOLD, 24)}
    val l6 = new Label{text = "How often do you have soft drinks"
                      font = new Font("Ariel", java.awt.Font.BOLD, 24)}
    val l7 = new Label{text = "Where do you eat your midday meal"
                      font = new Font("Ariel", java.awt.Font.BOLD, 24)}
    val l8 = new Label{text = "How often do you eat fast food"
                      font = new Font("Ariel", java.awt.Font.BOLD, 24)}
    val l9 = new Label{text = "How often do you go to school/bed hungry"
                      font = new Font("Ariel", java.awt.Font.BOLD, 24)}
    
    
    val l1_b1 = new RadioButton("0-1 day"){name = "1" 
                                          font = new Font("Ariel", java.awt.Font.PLAIN, 17)}
    val l1_b2 = new RadioButton("2-3 days"){name = "2"
                                          font = new Font("Ariel", java.awt.Font.PLAIN, 17)}
    val l1_b3 = new RadioButton("4-5 days"){name = "3"
                                          font = new Font("Ariel", java.awt.Font.PLAIN, 17)}
    val l1_b0 = new RadioButton("Do not wish to answer"){name = "0"
                                          font = new Font("Ariel", java.awt.Font.PLAIN, 17)}
    val l1Group = new ButtonGroup(l1_b1, l1_b2, l1_b3, l1_b0)
    
    val l2_b1 = new RadioButton("Never"){name = "1"
                                        font = new Font("Ariel", java.awt.Font.PLAIN, 17)}
    val l2_b2 = new RadioButton("1 day of the weekend"){name = "2"
                                        font = new Font("Ariel", java.awt.Font.PLAIN, 17)}
    val l2_b3 = new RadioButton("Both days"){name = "3"
                                        font = new Font("Ariel", java.awt.Font.PLAIN, 17)}
    val l2_b0 = new RadioButton("Do not wish to answer"){name = "0"
                                        font = new Font("Ariel", java.awt.Font.PLAIN, 17)}
    val l2Group = new ButtonGroup(l2_b1, l2_b2, l2_b3, l2_b0)
    
    val l3_b1 = new RadioButton("less than once a week"){name = "1"
                                                        font = new Font("Ariel", java.awt.Font.PLAIN, 17)}
//    val l3_b2 = new RadioButton("once a week"){name = "2"}
    val l3_b2 = new RadioButton("2-6 days a week"){name = "2"
                                                  font = new Font("Ariel", java.awt.Font.PLAIN, 17)}
    val l3_b3 = new RadioButton("Everyday"){name = "3"
                                           font = new Font("Ariel", java.awt.Font.PLAIN, 17)}
    val l3_b0 = new RadioButton("Do not wish to answer"){name = "0"
                                                        font = new Font("Ariel", java.awt.Font.PLAIN, 17)}
    val l3Group = new ButtonGroup(l3_b1, l3_b2, l3_b3, l3_b0)
    
    val l4_b1 = new RadioButton("less than once a week"){name = "1"
                                                        font = new Font("Ariel", java.awt.Font.PLAIN, 17)}
//    val l4_b2 = new RadioButton("once a week"){name = "2"}
    val l4_b2 = new RadioButton("2-6 days a week"){name = "2"
                                                  font = new Font("Ariel", java.awt.Font.PLAIN, 17)}
    val l4_b3 = new RadioButton("Everyday"){name = "3"
                                           font = new Font("Ariel", java.awt.Font.PLAIN, 17)}
    val l4_b0 = new RadioButton("Do not wish to answer"){name = "0"
                                                        font = new Font("Ariel", java.awt.Font.PLAIN, 17)}
    val l4Group = new ButtonGroup(l4_b1, l4_b2, l4_b3, l4_b0)
    
    val l5_b1 = new RadioButton("less than once a week"){name = "1"
                                                        font = new Font("Ariel", java.awt.Font.PLAIN, 17)}
 //   val l5_b2 = new RadioButton("once a week"){name = "2"}
    val l5_b2 = new RadioButton("2-6 days a week"){name = "2"
                                                  font = new Font("Ariel", java.awt.Font.PLAIN, 17)}
    val l5_b3 = new RadioButton("Everyday"){name = "3"
                                            font = new Font("Ariel", java.awt.Font.PLAIN, 17)}
    val l5_b0 = new RadioButton("Do not wish to answer"){name = "0"
                                                        font = new Font("Ariel", java.awt.Font.PLAIN, 17)}
    val l5Group = new ButtonGroup(l5_b1, l5_b2, l5_b3, l5_b0)
    
    val l6_b1 = new RadioButton("less than once a week"){name = "1"
                                                        font = new Font("Ariel", java.awt.Font.PLAIN, 17)}
 //   val l6_b2 = new RadioButton("once a week"){name = "2"}
    val l6_b2 = new RadioButton("2-6 days a week"){name = "2"
                                                  font = new Font("Ariel", java.awt.Font.PLAIN, 17)}
    val l6_b3 = new RadioButton("Everyday"){name = "3"
                                           font = new Font("Ariel", java.awt.Font.PLAIN, 17)}
    val l6_b0 = new RadioButton("Do not wish to answer"){name = "0"
                                                        font = new Font("Ariel", java.awt.Font.PLAIN, 17)}
    val l6Group = new ButtonGroup(l6_b1, l6_b2, l6_b3, l6_b0)
    
    val l7_b1 = new RadioButton("At school"){name = "1"
                                            font = new Font("Ariel", java.awt.Font.PLAIN, 17)}
    val l7_b2 = new RadioButton("At home"){name = "2"
                                          font = new Font("Ariel", java.awt.Font.PLAIN, 17)}
    val l7_b3 = new RadioButton("At someone else's home"){name = "3"
                                                         font = new Font("Ariel", java.awt.Font.PLAIN, 17)}
    val l7_b4 = new RadioButton("In snack bar/restaurant"){name = "4"
                                                          font = new Font("Ariel", java.awt.Font.PLAIN, 17)}
    val l7_b5 = new RadioButton("Somewhere else"){name = "5"
                                                 font = new Font("Ariel", java.awt.Font.PLAIN, 17)}
    val l7_b6 = new RadioButton("Never"){name = "6"
                                        font = new Font("Ariel", java.awt.Font.PLAIN, 17)}
    val l7_b7 = new RadioButton("Do not wish to answer"){name = "0"
                                                        font = new Font("Ariel", java.awt.Font.PLAIN, 17)}
    val l7Group = new ButtonGroup(l7_b1, l7_b2, l7_b3, l7_b4,l7_b5,l7_b6,l7_b7)
    
    val l8_b1 = new RadioButton("less than once a week"){name = "1"
                                                        font = new Font("Ariel", java.awt.Font.PLAIN, 17)}
//    val l8_b2 = new RadioButton("once a week"){name = "2"}
    val l8_b2 = new RadioButton("2-6 days a week"){name = "2"
                                                  font = new Font("Ariel", java.awt.Font.PLAIN, 17)}
    val l8_b3 = new RadioButton("Everyday"){name = "3"
                                           font = new Font("Ariel", java.awt.Font.PLAIN, 17)}
    val l8_b0 = new RadioButton("Do not wish to answer"){name = "0"
                                                        font = new Font("Ariel", java.awt.Font.PLAIN, 17)}
    val l8Group = new ButtonGroup(l8_b1, l8_b2, l8_b3, l8_b0)
    
    val l9_b1 = new RadioButton("Always"){name = "1"
                                         font = new Font("Ariel", java.awt.Font.PLAIN, 17)}
    val l9_b2 = new RadioButton("Often"){name = "2"
                                        font = new Font("Ariel", java.awt.Font.PLAIN, 17)}
    val l9_b3 = new RadioButton("Sometimes"){name = "3"
                                            font = new Font("Ariel", java.awt.Font.PLAIN, 17)}
    val l9_b4 = new RadioButton("Never"){name = "4"
                                        font = new Font("Ariel", java.awt.Font.PLAIN, 17)}
    val l9_b0 = new RadioButton("Do not wish to answer"){name = "0"
                                                        font = new Font("Ariel", java.awt.Font.PLAIN, 17)}
    val l9Group = new ButtonGroup(l9_b1, l9_b2, l9_b3, l9_b4, l9_b0)
    
    
    contents = new BoxPanel(Orientation.Vertical) {
      contents += l1
      contents += new BoxPanel(Orientation.Horizontal) {
        contents += l1_b1
        contents += Swing.HStrut(5)
        contents += l1_b2
        contents += Swing.HStrut(5)
        contents += l1_b3
        contents += Swing.HStrut(5)
        contents += l1_b0
        contents += Swing.HStrut(5)
        }
      contents += Swing.VStrut(5)
      contents += l2
      contents += new BoxPanel(Orientation.Horizontal) {
        contents += l2_b1
        contents += Swing.HStrut(5)
        contents += l2_b2
        contents += Swing.HStrut(5)
        contents += l2_b3
        contents += Swing.HStrut(5)
        contents += l2_b0
      }
      contents += Swing.VStrut(5)
      contents += l3
      contents += new BoxPanel(Orientation.Horizontal) {
        contents += l3_b1
        contents += Swing.HStrut(5)
        contents += l3_b2
        contents += Swing.HStrut(5)
        contents += l3_b3
        contents += Swing.HStrut(5)
        contents += l3_b0
      }
      contents += Swing.VStrut(5)
      contents += l4
      contents += new BoxPanel(Orientation.Horizontal) {
        contents += l4_b1
        contents += Swing.HStrut(5)
        contents += l4_b2
        contents += Swing.HStrut(5)
        contents += l4_b3
        contents += Swing.HStrut(5)
        contents += l4_b0
      }
      contents += Swing.VStrut(5)
      contents += l5
      contents += new BoxPanel(Orientation.Horizontal) {
        contents += l5_b1
        contents += Swing.HStrut(5)
        contents += l5_b2
        contents += Swing.HStrut(5)
        contents += l5_b3
        contents += Swing.HStrut(5)
        contents += l5_b0
      }
      contents += Swing.VStrut(5)
      contents += l6
      contents += new BoxPanel(Orientation.Horizontal) {
        contents += l6_b1
        contents += Swing.HStrut(5)
        contents += l6_b2
        contents += Swing.HStrut(5)
        contents += l6_b3
        contents += Swing.HStrut(5)
        contents += l6_b0
      }
      contents += Swing.VStrut(5)
      contents += l7
      contents += new BoxPanel(Orientation.Horizontal) {
        contents += l7_b1
        contents += Swing.HStrut(5)
        contents += l7_b2
        contents += Swing.HStrut(5)
        contents += l7_b3
        contents += Swing.HStrut(5)
        contents += l7_b4
        contents += Swing.HStrut(5)
        contents += l7_b5
        contents += Swing.HStrut(5)
        contents += l7_b6
        contents += Swing.HStrut(5)
        contents += l7_b7
        
      }
      contents += Swing.VStrut(5)
      contents += l8
      contents += new BoxPanel(Orientation.Horizontal) {
        contents += l8_b1
        contents += Swing.HStrut(5)
        contents += l8_b2
        contents += Swing.HStrut(5)
        contents += l8_b3
        contents += Swing.HStrut(5)
        contents += l8_b0
      }
      contents += Swing.VStrut(5)
      contents += l9
      contents += new BoxPanel(Orientation.Horizontal) {
        contents += l9_b1
        contents += Swing.HStrut(5)
        contents += l9_b2
        contents += Swing.HStrut(5)
        contents += l9_b3
        contents += Swing.HStrut(5)
        contents += l9_b4
        contents += Swing.HStrut(5)
        contents += l9_b0
        
      }
      contents += Swing.VStrut(5)
      contents += Button("Submit") { var message = Project.get_answer(total_value) 
                                      display(message)
                                      total_value = ""
                                    }
      contents += Swing.VStrut(20)
      contents += Button("Get Gender Statistics") { showGenderImage() }
      
      contents += Swing.VStrut(20)
      contents += Button("Get Female Statistics") { showFemaleStat() }
      
      contents += Swing.VStrut(20)
      contents += Button("Get Male Statistics") { showMaleStat() }
      
      
    }
    
    listenTo(l1_b1)
    listenTo(l1_b2)
    listenTo(l1_b3)
    listenTo(l1_b0)
    
    listenTo(l2_b1)
    listenTo(l2_b2)
    listenTo(l2_b3)
    listenTo(l2_b0)
    
    listenTo(l3_b1)
    listenTo(l3_b2)
    listenTo(l3_b3)
//    listenTo(l3_b4)
    listenTo(l3_b0)
    
    listenTo(l4_b1)
    listenTo(l4_b2)
    listenTo(l4_b3)
  //  listenTo(l4_b4)
    listenTo(l4_b0)
    
    listenTo(l5_b1)
    listenTo(l5_b2)
    listenTo(l5_b3)
    //listenTo(l5_b4)
    listenTo(l5_b0)
    
    listenTo(l6_b1)
    listenTo(l6_b2)
    listenTo(l6_b3)
//    listenTo(l6_b4)
    listenTo(l6_b0)
    
    listenTo(l7_b1)
    listenTo(l7_b2)
    listenTo(l7_b3)
    listenTo(l7_b4)
    listenTo(l7_b5)
    listenTo(l7_b6)
    listenTo(l7_b7)
    
    listenTo(l8_b1)
    listenTo(l8_b2)
    listenTo(l8_b3)
//    listenTo(l8_b4)
    listenTo(l8_b0)
    
    listenTo(l9_b1)
    listenTo(l9_b2)
    listenTo(l9_b3)
    listenTo(l9_b4)
    listenTo(l9_b0)
    
    reactions += {
      case ButtonClicked(s) =>
        println("Button click on button: '" + s.text + "'")
        total_value += s.name + " "
     }
    
    def display(m : String){
      Dialog.showMessage(contents.head, m, title="Your behaviour Results")
    }
    
    def showGenderImage(){
      val img = new ImageIcon("C:/Users/km327/Desktop/Books/BDAD/Project/Project/Bullyingender.png")
      Dialog.showMessage(message = null, icon = img)
    
    }
    
    def showFemaleStat(){
      val img = new ImageIcon("C:/Users/km327/Desktop/Books/BDAD/Project/Project/Nutrientfemale.png")
      Dialog.showMessage(message = null, icon = img)
    
    }
    
    def showMaleStat(){
      val img = new ImageIcon("C:/Users/km327/Desktop/Books/BDAD/Project/Project/Nutrientmale.png")
      Dialog.showMessage(message = null, icon = img)
    
    }
 }


 object Project {
  
   
  def main(args: Array[String]) {
    
   
    val ui = new UI
    ui.visible = true
 
  }
  
  
  
  def profileUS1(line : String):String = {
      val d = "[\t]+"
      val str = line.split(d)
      var r = "0"
      for(i <- 186 to 197) {
        if(str(i).toInt > 1)
        {
          r = "1"
        }
      }
    line + "\t" + r
    }

  
  def extractLabel(line :String):String = {
    val str = line.split('\t')
    str(250)
  }
    
    def extractVector(line : String): String = {val d = "[\t]+"
val str = line.split(d)
var s = ""

if( (str(69).toInt == 5 ) || (str(69).toInt == 6))
{
s = "3"
}
else if ((str(69).toInt == 4 ) || (str(69).toInt == 3))
{
s = "2"
}
else if ((str(69).toInt == 1 ) || (str(69).toInt == 2))
{
s = "1"
}
else
{
s = "0"
}

if ( (str(70).toInt == -9) || (str(70).toInt == -7))
{
s = s+" 0"
}
else
{
s = s+" "+str(70)
}

if( (str(71).toInt == 1 ) || (str(71).toInt == 2) || (str(71).toInt == 3))
{
s = s+" 1"
}
else if ((str(71).toInt == 4 ) || (str(71).toInt == 5))
{
s = s+" 2"
}
else if ((str(71).toInt == 6 ) || (str(71).toInt == 7))
{
s = s+" 3"
}
else
{
s = s+" 0"
}

if( (str(72).toInt == 1 ) || (str(72).toInt == 2) || (str(72).toInt == 3))
{
s = s+" 1"
}
else if ((str(72).toInt == 4 ) || (str(72).toInt == 5))
{
s = s+" 2"
}
else if ((str(72).toInt == 6 ) || (str(72).toInt == 7))
{
s = s+" 3"
}
else
{
s = s+" 0"
}

if( (str(73).toInt == 1 ) || (str(73).toInt == 2) || (str(73).toInt == 3))
{
s = s+" 1"
}
else if ((str(73).toInt == 4 ) || (str(73).toInt == 5))
{
s = s+" 2"
}
else if ((str(73).toInt == 6 ) || (str(73).toInt == 7))
{
s = s+" 3"
}
else
{
s = s+" 0"
}

if( (str(74).toInt == 1 ) || (str(74).toInt == 2) || (str(74).toInt == 3))
{
s = s+" 1"
}
else if ((str(74).toInt == 4 ) || (str(74).toInt == 5))
{
s = s+" 2"
}
else if ((str(74).toInt == 6 ) || (str(74).toInt == 7))
{
s = s+" 3"
}
else
{
s = s+" 0"
}

if(str(77).toInt == 1){
s = s+" "+"1"
}
else if(str(78).toInt == 1){
s = s+" "+"2"
}
else if(str(79).toInt == 1){
s = s+" "+"3"
}
else if(str(80).toInt == 1){
s = s+" "+"4"
}
else if(str(81).toInt == 1){
s = s+" "+"5"
}
else if(str(82).toInt == 1){
s = s+" "+"6"
}
else{
s = s+" "+0.0
}

if( (str(85).toInt == 1 ) || (str(85).toInt == 2) || (str(85).toInt == 3))
{
s = s+" 1"
}
else if ((str(85).toInt == 4 ) || (str(85).toInt == 5))
{
s = s+" 2"
}
else if ((str(85).toInt == 6 ) || (str(85).toInt == 7))
{
s = s+" 3"
}
else
{
s = s+" 0"
}

if( (str(86).toInt != -9) && (str(86).toInt != -7))
{
s = s+" "+str(86)
}
else
{
s = s+" "+0.0
}

s}
    
    def scObject(): org.apache.spark.rdd.RDD[String] = {
      val conf = new SparkConf().setAppName("Simple Application").setMaster("local[*]")
      val sc = new SparkContext(conf)  
      val USdata1 = sc.textFile("C:/Users/km327/Desktop/Books/BDAD/Project/Datasets/data1.txt")
      USdata1.map(line => profileUS1(line))
    }
    
    def train(): LogisticRegressionModel = { 
      val new_data = scObject()
      val parsedData = new_data.map{line => 
        val label = extractLabel(line)
        val value = extractVector(line)
        val d = "[ ]+"
        val parts = value.split(d)
        LabeledPoint(label.toDouble, Vectors.dense(parts.map(x => x.toDouble)))
      }
      new LogisticRegressionWithLBFGS().setNumClasses(2).run(parsedData)
    }
    
    def get_answer(ans : String): String = {
      //test
      val model = train()
      val delim = "[ ]+"
      val feature = ans.split(delim)
      val test = LabeledPoint(1.0, Vectors.dense(feature.map(x => x.toDouble)))
      val prediction = model.predict(test.features)
      var message = ""
      if(prediction == 1.0)
        message += "Beware!! Risk of being a bully"
      else
        message += "You are good!!!"
      
     message      
    }
    
      
  
}