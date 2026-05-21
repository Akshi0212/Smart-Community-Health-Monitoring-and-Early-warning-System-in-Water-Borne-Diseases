package usecases

import com.example.jalrakshakapp.data.SensorRepository
import com.example.jalrakshakapp.data.WaterQualityData
import kotlinx.coroutines.flow.Flow

class GetSensorDataUseCase(private val repository: SensorRepository) {

    // Return the Flow directly from the repository
    operator fun invoke(): Flow<WaterQualityData> {
        return repository.sensorData
    }
}
