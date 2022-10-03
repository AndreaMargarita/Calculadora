package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button btn0,btn1, btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnc,btneliminar,btnsumar,btnrestar,btndividir,btnpunto,btnmultiplicar,btnigual;
    EditText pntlltexto;
    Float numero1=0.0f;
    Float numero2=0.0f;
    String operador = "";
    Boolean ClickSepadorDecimal = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pntlltexto= findViewById(R.id.txtpantalla);
        btn0 =findViewById(R.id.btn0);
        btn1 =findViewById(R.id.btn1);
        btn2 =findViewById(R.id.btn2);
        btn3 =findViewById(R.id.btn3);
        btn4 =findViewById(R.id.btn4);
        btn5 =findViewById(R.id.btn5);
        btn6 =findViewById(R.id.btn6);
        btn7 =findViewById(R.id.btn7);
        btn8 =findViewById(R.id.btn8);
        btn9 =findViewById(R.id.btn9);
        btnc = findViewById(R.id.btnc);
        btneliminar = findViewById(R.id.btneliminar);
        btnsumar = findViewById(R.id.btnsuma);
        btnrestar = findViewById(R.id.btnres);
        btndividir = findViewById(R.id.btndiv);
        btnpunto =  findViewById(R.id.btnpunto);
        btnmultiplicar = findViewById(R.id.btnmult);
        btnigual = findViewById(R.id.btnigual);

        btnc.setOnClickListener(this::Limpiar);
        btneliminar.setOnClickListener(this::Eliminar);
        btnigual.setOnClickListener(this::Igual);
        btnmultiplicar.setOnClickListener(this::Multiplicar);
        btnpunto.setOnClickListener(this::Punto);
        btndividir.setOnClickListener(this::Dividir);
        btnrestar.setOnClickListener(this::Restar);
        btnsumar.setOnClickListener(this::Sumar);
        btn0.setOnClickListener(this::onClick);
        btn1.setOnClickListener(this::onClick);
        btn2.setOnClickListener(this::onClick);
        btn3.setOnClickListener(this::onClick);
        btn4.setOnClickListener(this::onClick);
        btn5.setOnClickListener(this::onClick);
        btn6.setOnClickListener(this::onClick);
        btn7.setOnClickListener(this::onClick);
        btn8.setOnClickListener(this::onClick);
        btn9.setOnClickListener(this::onClick);

        pntlltexto .setText("0");

    }

    @SuppressLint("SetTextI18n")
    private void Punto(View view)
    {
        if(pntlltexto.getText().toString().equals(""))
        {
            pntlltexto .setText("0");
        }else
        {
            if (ClickSepadorDecimal == false)
            {
                pntlltexto.setText(pntlltexto.getText() + ".");
                ClickSepadorDecimal = true;
            }

        }

    }

    private void Eliminar(View view)
    {
        if(pntlltexto.getText().toString().equals("0") || pntlltexto.getText().toString().equals(""))
        {
            pntlltexto .setText("0");
        }
        else
        {
            String text = pntlltexto.getText().toString(); pntlltexto.setText(text.substring(0,text.length()-1));
                ClickSepadorDecimal = false;

        }

    }

    private void Limpiar(View view)
    {
        pntlltexto.setText("0");
        numero1 = 0.0f;
        numero2 =0.0f;
        operador= "";
        ClickSepadorDecimal = false;
    }
    private void Igual(View view)
    {
        Float resultado =0.0f;

        numero2 = Float.parseFloat(pntlltexto.getText().toString());

        switch (operador)
        {
            case ("+"):
            {
              resultado =  numero1 + numero2;
              pntlltexto.setText(String.valueOf(resultado));
            } break;
            case ("-"):
            {
                resultado =  numero1 - numero2;
                pntlltexto.setText(String.valueOf(resultado));
            } break;
            case ("*"):
            {
                resultado =  numero1 * numero2;
                pntlltexto.setText(String.valueOf(resultado));
            }
            break;
            case ("/"):
            {
                resultado =  numero1 / numero2;
                pntlltexto.setText(String.valueOf(resultado));
            }

        }
    }

    private void Guardarnumero1(View view)
    {
        numero1 = Float.parseFloat(pntlltexto.getText().toString());
        pntlltexto.setText(operador);
    }

    private void Multiplicar(View view)
    {
        operador = "*";
        ClickSepadorDecimal = false;
        Guardarnumero1(view);
    }

    private void Sumar(View view)
    {
        operador = "+";
        ClickSepadorDecimal = false;
        Guardarnumero1(view);
    }

    private void Restar(View view)
    {
        operador = "-";
        ClickSepadorDecimal = false;
        Guardarnumero1(view);
    }

    private void Dividir(View view)
    {
        operador = "/";
        ClickSepadorDecimal = false;
        Guardarnumero1(view);
    }

    @SuppressLint("SetTextI18n")
    public void onClick (View view)
    {
        //int id_boton = view.getId();
        Button b = (Button)view;
        String text = b.getText().toString();

        if(pntlltexto.getText().toString().equals("0"))
        {
            pntlltexto.setText(text);
        }else
        {
            pntlltexto.setText(pntlltexto.getText() + text);
        }
      /*  switch (id_boton)
        {
            case (R.id.btn0):
            {
                if(pntlltexto.getText().toString().equals("0"))
                {
                    pntlltexto.setText("0");
                }else
                {
                    pntlltexto.setText(pntlltexto.getText() + "0");
                }
            }break;
            case (R.id.btn1):
            {
                if(pntlltexto.getText().toString().equals("0"))
                {
                    pntlltexto.setText("1");
                }else
                {
                    pntlltexto.setText(pntlltexto.getText() + "1");
                }
            }break;
            case (R.id.btn2):
            {
                if(pntlltexto.getText().toString().equals("0"))
                {
                    pntlltexto.setText("2");
                }else
                {
                    pntlltexto.setText(pntlltexto.getText() + "2");
                }
            }break;
            case (R.id.btn3):
            {
                if(pntlltexto.getText().toString().equals("0"))
                {
                    pntlltexto.setText("3");
                }else
                {
                    pntlltexto.setText(pntlltexto.getText() + "3");
                }
            }break;
            case (R.id.btn4):
            {
                if(pntlltexto.getText().toString().equals("0"))
                {
                    pntlltexto.setText("4");
                }else
                {
                    pntlltexto.setText(pntlltexto.getText() + "4");
                }
            }break;
            case (R.id.btn5):
            {
                if(pntlltexto.getText().toString().equals("0"))
                {
                    pntlltexto.setText("5");
                }else
                {
                    pntlltexto.setText(pntlltexto.getText() + "5");
                }
            }break;
            case (R.id.btn6):
            {
                if(pntlltexto.getText().toString().equals("0"))
                {
                    pntlltexto.setText("6");
                }else
                {
                    pntlltexto.setText(pntlltexto.getText() + "6");
                }
            }break;
            case (R.id.btn7):
            {
                if(pntlltexto.getText().toString().equals("0"))
                {
                    pntlltexto.setText("7");
                }else
                {
                    pntlltexto.setText(pntlltexto.getText() + "7");
                }
            }break;
            case (R.id.btn8):
            {
                if(pntlltexto.getText().toString().equals("0"))
                {
                    pntlltexto.setText("8");
                }else
                {
                    pntlltexto.setText(pntlltexto.getText() + "8");
                }
            }break;
            case (R.id.btn9):
            {
                if(pntlltexto.getText().toString().equals("0"))
                {
                    pntlltexto.setText("9");
                }else
                {
                    pntlltexto.setText(pntlltexto.getText() + "9");
                }
            }break;
        }*/
    }
}