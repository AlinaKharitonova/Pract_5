import kotlin.random.Random

fun main() {

    //class Point
    val testPoint:Point = Point(arrayOf(1.0,2.0))
    testPoint.printPoint()

    //class ColoredPoint
    val testColoredPoint:coloredPoint = coloredPoint(arrayOf(2.0,3.4), coloredPoint.ColorPoint.Pink)
    testColoredPoint.printPoint()

    //class Line
    val testLine: Line = Line(arrayOf(4.9,6.9,5.9,6.9))
    testLine.printLine()

    class ColoredLine
    val testColoredLine: coloredLine = coloredLine(arrayOf(1.0,3.9,2.8,2.0))
    testColoredLine.colorLine = coloredLine.ColorLine.White
    testColoredLine.printLine()

 //   class Polygone
    val randomCorners = Random.nextInt(3,100)
    val randomPoints = Array(randomCorners * 2){
        Random.nextDouble(0.0,10.0)
    }

    val testPolygone: Polygone = Polygone(randomPoints,15)
    testPolygone.movingPointPolygone(1.0)
    testPolygone.printPolygone()


}



open class Point(_XY: Array<Double>) {

    var arrayPoint = Array(2,{0.0})

    var x: Double = arrayPoint[0]
    var y: Double = arrayPoint[1]

    init{
        x = _XY[0]
        y =_XY[1]
    }

    open fun printPoint(){

        println("XY: ($x, $y)")
    }

}


class coloredPoint(_XYColored: Array<Double>): Point(_XYColored){

    enum class ColorPoint{
        Red, Blue, Green, Black, White, Pink, Purple, Yellow, Orange
    }
    var colorPoint: ColorPoint = ColorPoint.Blue

    constructor(_XYColored: Array<Double>, _color:ColorPoint):this(_XYColored){
        colorPoint = _color
    }

    override fun printPoint(){
        println("XY: ($x, $y) color: $colorPoint")
    }

}


open class Line(_pointLine: Array<Double>):Point(_pointLine){
    var arrayPointLine = Array(4, {0.0})

    var beginX: Double = arrayPointLine[0]
    var beginY: Double = arrayPointLine[1]
    var endX: Double = arrayPointLine[2]
    var endY: Double = arrayPointLine[3]

    init{
        beginX = _pointLine[0]
        beginY = _pointLine[1]
        endX = _pointLine[2]
        endY= _pointLine[3]
    }

    open fun printLine(){
        println("First point: ($beginX, $beginY), Second point:($endX, $endY)")
    }

}


class coloredLine(_pointColoredLine: Array<Double>): Line(_pointColoredLine){

    enum class ColorLine{
        Red, Blue, Green, Black, White, Pink, Purple, Yellow, Orange
    }
    var colorLine: ColorLine = ColorLine.Red

    constructor(_pointColoredLine: Array<Double>, _colorLine:ColorLine):this(_pointColoredLine){
        colorLine = _colorLine
    }

    override fun  printLine(){
        println("First point: ($beginX, $beginY), Second point:($endX, $endY), Color: $colorLine")
    }

}


class Polygone(_pointPolygone: Array<Double>): Line(_pointPolygone) {

    var countCorner: Int = 3
        set(value) {
             field = value

        }

    var arrayPointPolygone = Array(countCorner * 2, { 0.0 })

    constructor(_pointPolygone: Array<Double>, _countCorner: Int) : this(_pointPolygone) {
        countCorner = _countCorner

    }

    init {
        arrayPointPolygone = _pointPolygone
    }

    fun printPolygone(){
        for(i in 0..countCorner-1){
            val x = String.format("%.1f", arrayPointPolygone[i * 2])
            val y = String.format("%.1f", arrayPointPolygone[i * 2 + 1])
            println("XY${i + 1}: $x, $y")
        }
    }
    fun movingPointPolygone(numberMov:Double) {

        println("Number of angles: $countCorner")

        var num = 1.0
        var resMoving: Array<Double> = Array(countCorner*2,{0.0})

        for(i in 0..countCorner-1){

            resMoving[i * 2] = arrayPointPolygone[i * 2] - numberMov
            resMoving[i * 2 + 1] = arrayPointPolygone[i * 2 + 1] - numberMov
            val movedX = String.format("%.1f", resMoving[i * 2])
            val movedY = String.format("%.1f", resMoving[i * 2 + 1])
            println("Result moving: XY${i + 1}: $movedX, $movedY") }

    }

}