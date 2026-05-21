package com.example.jalrakshakapp.domain.usecases

import com.example.jalrakshakapp.data.SensorReading
import com.example.jalrakshakapp.data.WaterQualityStatus

class AnalyzeWaterQualityUseCase {
    operator fun invoke(sensorData: SensorReading): WaterQualityStatus {
        return when {
            // Excellent: All parameters within ideal range
            sensorData.turbidity < 1.0f &&
                    sensorData.phLevel in 6.5f..8.5f &&
                    sensorData.tds < 300f &&
                    sensorData.dissolvedOxygen > 6.0f ->
                WaterQualityStatus("EXCELLENT", "Safe to Drink", false)

            // Good: Slightly outside ideal but still safe
            sensorData.turbidity < 5.0f &&
                    sensorData.phLevel in 6.0f..9.0f &&
                    sensorData.tds < 500f ->
                WaterQualityStatus("GOOD", "Generally Safe", false)

            // Fair: Needs attention
            sensorData.turbidity < 10.0f &&
                    sensorData.phLevel in 5.5f..9.5f ->
                WaterQualityStatus("FAIR", "Needs Treatment", false)

            // Poor: Unsafe for consumption
            else -> WaterQualityStatus(
                "POOR",
                "Not Safe to Drink",
                true,
                listOf(getContaminantWarning(sensorData)),
                listOf("Use water purifier", "Boil before use")
            )
        }
    }

    private fun getContaminantWarning(data: SensorReading): String {
        return when {
            data.turbidity > 10f -> "High turbidity detected"
            data.phLevel < 6.5f -> "Acidic water"
            data.phLevel > 8.5f -> "Alkaline water"
            data.tds > 500f -> "High mineral content"
            else -> "Water quality issues"
        }
    }
}