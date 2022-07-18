package com.example.mvp_android.models

import android.os.Handler
import com.example.mvp_android.contracts.Contract
import java.util.*


class Model : Contract.Model {

    private val arrayList = Arrays.asList(
        "Modelo: Capa de almacenamiento de datos. Responsable de manejar la lógica del dominio. ",
        "Vista: Capa de Interfaz de Usuario. Proporciona la visualización de los datos y notifica al presentador de acuerdo a las acciones del usuario.",
        "Presentador: Obtiene los datos del modelo y aplica la lógica de la Interfaz de usuario para decidir que mostrar.",
        "Contrato: Hace posible la comunicación entre View-Presenter y Presenter-Model.",
        // "Low Level Design for SDE 1 Interview: Learn Object-oriented Analysis and Design to prepare for SDE 1 Interviews in top companies"
    )

    override fun getNextComponentDescription(onFinishedListener: Contract.Model.OnFinishedListener) {
        Handler().postDelayed({onFinishedListener!!.onFinished(getRandomString)}, 1200)
    }

    private val getRandomString: String
        private get() {
            val random = Random();
            val index = random.nextInt(arrayList.size)
            return arrayList[index];
        }

}