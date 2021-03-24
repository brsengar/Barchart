package com.gtsl.barcharttest

import android.content.Context
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.IAxisValueFormatter
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet

class BarChartGenerator {

    private val MAX_X_VALUE = 6
    private val MAX_Y_VALUE = 50
    private val MIN_Y_VALUE = 5
    private val STACK_1_LABEL = "Stack 1"
    private val STACK_2_LABEL = "Stack 2"
    private val STACK_3_LABEL = "Stack 3"
    private val SET_LABEL = "Set ABC"

    fun generateBarChart(
        context: Context,
        barChart: BarChart,
        data: List<FirstFragment.Usage>
    ) {

        prepareChartAppearance(barChart)
        val xLabels = configureXAxisData()
        val bars = configureYAxisData(context)

        barChart.xAxis.valueFormatter = IAxisValueFormatter {
                value, _ -> xLabels.get(value.toInt())
        }

        val data: BarData = createChartData(context)
        prepareChartData(barChart, data)

    }

    private fun prepareChartAppearance(chart: BarChart) {
        chart.setDrawGridBackground(false)
        chart.description.isEnabled = false
        chart.xAxis.granularity = 1f
        chart.xAxis.setDrawGridLines(false)
        chart.xAxis.position = XAxis.XAxisPosition.BOTTOM

        chart.axisLeft.setDrawGridLines(true)
        chart.axisLeft.setDrawAxisLine(false)
        chart.axisLeft.mAxisMaximum = 100f
        chart.axisLeft.mAxisMinimum = 0f
        chart.axisLeft.labelCount = 2

        chart.axisRight.setDrawGridLines(false)
        chart.axisRight.setDrawLabels(false)
        chart.axisRight.isEnabled = false


    }

    private fun configureData(): List<Pair<String, Bar>>

    private fun configureXAxisData(): List<String> {
        val xLabel: ArrayList<String> = ArrayList()
        xLabel.add("")
        xLabel.add("Jan")
        xLabel.add("Feb")
        xLabel.add("Mar")
        xLabel.add("Apr")
        xLabel.add("May")
        xLabel.add("")
        xLabel.add("")

        return xLabel
    }

    private fun configureYAxisData(context: Context, List<>): BarData {
        val values: ArrayList<BarEntry> = ArrayList()

        for (i in 1 until MAX_X_VALUE) {
            val value1: Float = 10f
            values.add(BarEntry(i.toFloat(), value1))
        }

        val set1 = BarDataSet(values, "")
        set1.color = context.getColor(R.color.tesco_blue)
        val dataSets: ArrayList<IBarDataSet> = ArrayList()
        dataSets.add(set1)
        return BarData(dataSets)
    }

    private fun createChartData(context: Context): BarData {
        val values: ArrayList<BarEntry> = ArrayList()

        for (i in 1 until MAX_X_VALUE) {
            val value1: Float = Math.max(MIN_Y_VALUE.toFloat(), Math.random().toFloat() * (MAX_Y_VALUE + 1))
            values.add(BarEntry(i.toFloat(), value1))
        }

        val set1 = BarDataSet(values, "")
        set1.color = context.getColor(R.color.tesco_blue)
        val dataSets: ArrayList<IBarDataSet> = ArrayList()
        dataSets.add(set1)
        return BarData(dataSets)
    }

    private fun prepareChartData(chart: BarChart, data: BarData) {
        data.setValueTextSize(12f)
        data.barWidth = 0.3f
        chart.setData(data)
        chart.setFitBars(false)
        chart.legend.isEnabled = false
        chart.setVisibleXRange(1f, 7f)

        val barChartRender = CustomBarChartRender(chart, chart.getAnimator(), chart.getViewPortHandler())
        barChartRender.setRadius(30)
        chart.setRenderer(barChartRender)
        chart.setNoDataText("No data in the chart")
        chart.animateXY(2000, 2000)
        chart.invalidate()
    }



    private fun configureChartAppearance_old(chart: BarChart) {
        chart.setDrawGridBackground(false)
//        chart.setDrawValueAboveBar(false)
        chart.description.isEnabled = false
//        val xAxis: XAxis = chart.getXAxis()
        chart.xAxis.granularity = 1f
//        xAxis.setCenterAxisLabels(true)
        chart.xAxis.setDrawGridLines(false)
        chart.xAxis.position = XAxis.XAxisPosition.BOTTOM

        chart.axisLeft.setDrawGridLines(true)
        chart.axisLeft.setDrawAxisLine(false)
        chart.axisLeft.mAxisMaximum = 100f
        chart.axisLeft.mAxisMinimum = 0f
        chart.axisLeft.labelCount = 2

        val rightAxis: YAxis = chart.getAxisRight()
        rightAxis.setDrawGridLines(false)
        rightAxis.setDrawLabels(false)
        rightAxis.isEnabled = false

        val xLabel: ArrayList<String> = ArrayList()
        xLabel.add("")
        xLabel.add("Jan")
        xLabel.add("Feb")
        xLabel.add("Mar")
        xLabel.add("Apr")
        xLabel.add("May")
        xLabel.add("")
        xLabel.add("")
        chart.xAxis.valueFormatter = IAxisValueFormatter {
                value, axis -> xLabel.get(value.toInt())
        }
//        xAxis.textColor = Color.BLACK
//        xAxis.textSize = 12f
//        xAxis.axisLineColor = Color.WHITE
//        xAxis.axisMinimum = 1f
//        xAxis.valueFormatter = xAxisFormatter

    }

    private fun createChartData1(context: Context): BarData {
        val values: ArrayList<BarEntry> = ArrayList()

        for (i in 1 until MAX_X_VALUE) {
            val value1: Float = Math.max(MIN_Y_VALUE.toFloat(), Math.random().toFloat() * (MAX_Y_VALUE + 1))
            values.add(BarEntry(i.toFloat(), value1))
        }

        val set1 = BarDataSet(values, "")
        set1.color = context.getColor(R.color.tesco_blue)?:0
//        set1.setValueFormatter { value, entry, dataSetIndex, viewPortHandler ->  }
//        set1.setColors(*intArrayOf(ColorTemplate.MATERIAL_COLORS[0], ColorTemplate.MATERIAL_COLORS[1], ColorTemplate.MATERIAL_COLORS[2]))
//        set1.stackLabels = arrayOf(STACK_1_LABEL, STACK_2_LABEL, STACK_3_LABEL)
        val dataSets: ArrayList<IBarDataSet> = ArrayList()
        dataSets.add(set1)
        return BarData(dataSets)
    }


}