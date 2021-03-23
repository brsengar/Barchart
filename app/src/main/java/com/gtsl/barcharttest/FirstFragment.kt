package com.gtsl.barcharttest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.IAxisValueFormatter
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val chart = view.findViewById(R.id.chart) as BarChart

        BarChartGenerator().generateBarChart(this.requireContext(), chart, generateData())
    }

    data class Usage(
        val month: String,
        val value: Float
    )

    private fun generateData(): List<Usage> {
        return arrayListOf(
            Usage("Jan", 6.7f),
            Usage("Feb", 7f),
            Usage("Mar", 8f),
            Usage("Apr", 23f),
            Usage("May", 5f),
            Usage("Jun", 12f),
            Usage("Jul", 6f),
            Usage("Aug", 26f)
        )
    }


//    private fun configureChartAppearance(chart: BarChart) {
//        chart.getDescription().setEnabled(false);
//
//        val xAxis = chart.getXAxis();
//        xAxis.setValueFormatter(object: ValueFormatter() {
//            public String getFormattedValue(float value) {
//                return DAYS[(int) value];
//            }
//        });
//    }




//    private fun getDataSet(): IBarDataSet {
//        val valueSet1 = ArrayList<BarEntry>()
//        val v1e1 = BarEntry(110.000f, 0f) // Jan
//        valueSet1.add(v1e1)
//        val v1e2 = BarEntry(40.000f, 1f) // Feb
//        valueSet1.add(v1e2)
//        val v1e3 = BarEntry(60.000f, 2f) // Mar
//        valueSet1.add(v1e3)
//        val v1e4 = BarEntry(30.000f, 3f) // Apr
//        valueSet1.add(v1e4)
//        val v1e5 = BarEntry(90.000f, 4f) // May
//        valueSet1.add(v1e5)
//        val v1e6 = BarEntry(100.000f, 5f) // Jun
//        valueSet1.add(v1e6)
//        val v1e7 = BarEntry(100.000f, 7f) // Jun
//        valueSet1.add(v1e7)
//
//        val barDataSet1 = BarDataSet(valueSet1, "Brand 1")
//
//        barDataSet1.color = Color.rgb(0, 155, 0)
//
//        return barDataSet1
//    }

//    private fun getXAxisValues(): IBarDataSet {
//        val xAxis = ArrayList<String>()
//        xAxis.add("JAN")
//        xAxis.add("FEB")
//        xAxis.add("MAR")
//        xAxis.add("APR")
//        xAxis.add("MAY")
//        xAxis.add("JUN")
//        return xAxis
//    }
}