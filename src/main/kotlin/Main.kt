import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import java.io.OutputStream

class Main {
    companion object {
        @JvmStatic fun main(args: Array<String>) {
            val startTime = System.currentTimeMillis()

            val fann = FannkuchRedux()
            fann.runBenchmark(10)

            val endTime = System.currentTimeMillis()
            val runtime = endTime - startTime
            val res = Response().createString(startTime, runtime)
            println(res)
        }
    }

    fun handler(output: OutputStream): Unit {
        val startTime = System.currentTimeMillis()
        val mapper = jacksonObjectMapper()

        val fann = FannkuchRedux()
        fann.runBenchmark(10)

        val endTime = System.currentTimeMillis()
        val runtime = endTime - startTime
        val res = Response().createJson(startTime, runtime)
        println(res)

        mapper.writeValue(output, res)
    }
}
