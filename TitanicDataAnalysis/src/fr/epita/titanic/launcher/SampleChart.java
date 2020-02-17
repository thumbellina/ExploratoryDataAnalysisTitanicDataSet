package fr.epita.titanic.launcher;

import org.knowm.xchart.internal.chartpart.Chart;

public interface SampleChart<C extends Chart<?, ?>>  {
	C getChart();

}
