package com.example.oldspice.android_alerts

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //Creamos la accion al presionar el boton "SIMPLE ALERT"
        buttonSimple.onClick {

            //Declaramos que es una alert, insertamos el texto y el
            // titulo a mostrar
            alert("Esto es un Simple Alert", "ALERT") {

                //Dentro de la alerta contiene 2 botones, declaramos
                // la accion al presionar cada boton
                yesButton { longToast("Presionaste Si") }
                noButton { longToast("Presionaste No") }
            }.show() //<--Importante para mostrar alerta
        }

        //Creamos la accion al presionar el boton
        // "LIST ALERT"
        buttonList.onClick {

            //Creamos una variable que contiene una lista
            val paises = listOf("MEX", "ESP", "ARG", "COL")

            //Declaramos que es una alerta con selector,
            //insertamos el texto, las opciones que podra
            //seleccionar y al final declaramos que hacer
            //despues de seleccionar alguna opcion
            selector("¿De dónde eres?", paises) { dialogInterface, i ->
                longToast("Vives en ${paises[i]}")
            }
        }

        //Creamos la accion al presionar el boton
        // "PROGRESS DIALOG"
        buttonProgress.onClick {

            //Creamos una variable, declaramos que es un
            //progress dialog
            //insertamos el texto y titulo que mostrara
            val dialog = progressDialog(
                    message = "Por favor espera un momento",
                    title = "Cargando datos")
        }
    }


}
