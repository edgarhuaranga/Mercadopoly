package com.triunfo.mercadopoly;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ExhibicionMesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ExhibicionMesFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "mes";
    private static final String ARG_PARAM2 = "cliente";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public ExhibicionMesFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static ExhibicionMesFragment newInstance(String cliente, String mes) {
        ExhibicionMesFragment fragment = new ExhibicionMesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, mes);
        args.putString(ARG_PARAM2, cliente);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_exhibicion_mes, container, false);

        LinearLayout tablaAgosto = (LinearLayout) view.findViewById(R.id.tabla_agosto);
        LinearLayout tablaSetiembre = (LinearLayout) view.findViewById(R.id.tabla_setiembre);
        LinearLayout tablaOctubre = (LinearLayout) view.findViewById(R.id.tabla_octubre);
        LinearLayout tablaNoviembre = (LinearLayout) view.findViewById(R.id.tabla_noviembre);
        LinearLayout tablaDiciembre = (LinearLayout) view.findViewById(R.id.tabla_diciembre);
        LinearLayout tablaEnero = (LinearLayout) view.findViewById(R.id.tabla_enero);

        if(mParam1.equalsIgnoreCase("agosto")) tablaAgosto.setVisibility(View.VISIBLE);
        if(mParam1.equalsIgnoreCase("setiembre")) tablaSetiembre.setVisibility(View.VISIBLE);
        if(mParam1.equalsIgnoreCase("octubre")) tablaOctubre.setVisibility(View.VISIBLE);
        if(mParam1.equalsIgnoreCase("noviembre")) tablaNoviembre.setVisibility(View.VISIBLE);
        if(mParam1.equalsIgnoreCase("diciembre")) tablaDiciembre.setVisibility(View.VISIBLE);
        if(mParam1.equalsIgnoreCase("enero")) tablaEnero.setVisibility(View.VISIBLE);

        Cliente cliente = new Cliente(mParam2, getActivity().getApplicationContext());

        TextView productosExhigidosSem[] = new TextView[27];
        TextView productosEncontradosSem[] = new TextView[27];
        TextView productosEvaluadosSem[] = new TextView[27];

        productosExhigidosSem[1] = (TextView) view.findViewById(R.id.textview_productos_exhigidos_sem01);
        productosExhigidosSem[2] = (TextView) view.findViewById(R.id.textview_productos_exhigidos_sem02);
        productosExhigidosSem[3] = (TextView) view.findViewById(R.id.textview_productos_exhigidos_sem03);
        productosExhigidosSem[4] = (TextView) view.findViewById(R.id.textview_productos_exhigidos_sem04);
        productosExhigidosSem[5] = (TextView) view.findViewById(R.id.textview_productos_exhigidos_sem05);
        productosExhigidosSem[6] = (TextView) view.findViewById(R.id.textview_productos_exhigidos_sem06);
        productosExhigidosSem[7] = (TextView) view.findViewById(R.id.textview_productos_exhigidos_sem07);
        productosExhigidosSem[8] = (TextView) view.findViewById(R.id.textview_productos_exhigidos_sem08);
        productosExhigidosSem[9] = (TextView) view.findViewById(R.id.textview_productos_exhigidos_sem09);
        productosExhigidosSem[10] = (TextView) view.findViewById(R.id.textview_productos_exhigidos_sem10);
        productosExhigidosSem[11] = (TextView) view.findViewById(R.id.textview_productos_exhigidos_sem11);
        productosExhigidosSem[12] = (TextView) view.findViewById(R.id.textview_productos_exhigidos_sem12);
        productosExhigidosSem[13] = (TextView) view.findViewById(R.id.textview_productos_exhigidos_sem13);
        productosExhigidosSem[14] = (TextView) view.findViewById(R.id.textview_productos_exhigidos_sem14);
        productosExhigidosSem[15] = (TextView) view.findViewById(R.id.textview_productos_exhigidos_sem15);
        productosExhigidosSem[16] = (TextView) view.findViewById(R.id.textview_productos_exhigidos_sem16);
        productosExhigidosSem[17] = (TextView) view.findViewById(R.id.textview_productos_exhigidos_sem17);
        productosExhigidosSem[18] = (TextView) view.findViewById(R.id.textview_productos_exhigidos_sem18);
        productosExhigidosSem[19] = (TextView) view.findViewById(R.id.textview_productos_exhigidos_sem19);
        productosExhigidosSem[20] = (TextView) view.findViewById(R.id.textview_productos_exhigidos_sem20);
        productosExhigidosSem[21] = (TextView) view.findViewById(R.id.textview_productos_exhigidos_sem21);
        productosExhigidosSem[22] = (TextView) view.findViewById(R.id.textview_productos_exhigidos_sem22);
        productosExhigidosSem[23] = (TextView) view.findViewById(R.id.textview_productos_exhigidos_sem23);
        productosExhigidosSem[24] = (TextView) view.findViewById(R.id.textview_productos_exhigidos_sem24);
        productosExhigidosSem[25] = (TextView) view.findViewById(R.id.textview_productos_exhigidos_sem25);
        productosExhigidosSem[26] = (TextView) view.findViewById(R.id.textview_productos_exhigidos_sem26);

        productosEncontradosSem[1] = (TextView) view.findViewById(R.id.textview_productos_encontrados_sem01);
        productosEncontradosSem[2] = (TextView) view.findViewById(R.id.textview_productos_encontrados_sem02);
        productosEncontradosSem[3] = (TextView) view.findViewById(R.id.textview_productos_encontrados_sem03);
        productosEncontradosSem[4] = (TextView) view.findViewById(R.id.textview_productos_encontrados_sem04);
        productosEncontradosSem[5] = (TextView) view.findViewById(R.id.textview_productos_encontrados_sem05);
        productosEncontradosSem[6] = (TextView) view.findViewById(R.id.textview_productos_encontrados_sem06);
        productosEncontradosSem[7] = (TextView) view.findViewById(R.id.textview_productos_encontrados_sem07);
        productosEncontradosSem[8] = (TextView) view.findViewById(R.id.textview_productos_encontrados_sem08);
        productosEncontradosSem[9] = (TextView) view.findViewById(R.id.textview_productos_encontrados_sem09);
        productosEncontradosSem[10] = (TextView) view.findViewById(R.id.textview_productos_encontrados_sem10);
        productosEncontradosSem[11] = (TextView) view.findViewById(R.id.textview_productos_encontrados_sem11);
        productosEncontradosSem[12] = (TextView) view.findViewById(R.id.textview_productos_encontrados_sem12);
        productosEncontradosSem[13] = (TextView) view.findViewById(R.id.textview_productos_encontrados_sem13);
        productosEncontradosSem[14] = (TextView) view.findViewById(R.id.textview_productos_encontrados_sem14);
        productosEncontradosSem[15] = (TextView) view.findViewById(R.id.textview_productos_encontrados_sem15);
        productosEncontradosSem[16] = (TextView) view.findViewById(R.id.textview_productos_encontrados_sem16);
        productosEncontradosSem[17] = (TextView) view.findViewById(R.id.textview_productos_encontrados_sem17);
        productosEncontradosSem[18] = (TextView) view.findViewById(R.id.textview_productos_encontrados_sem18);
        productosEncontradosSem[19] = (TextView) view.findViewById(R.id.textview_productos_encontrados_sem19);
        productosEncontradosSem[20] = (TextView) view.findViewById(R.id.textview_productos_encontrados_sem20);
        productosEncontradosSem[21] = (TextView) view.findViewById(R.id.textview_productos_encontrados_sem21);
        productosEncontradosSem[22] = (TextView) view.findViewById(R.id.textview_productos_encontrados_sem22);
        productosEncontradosSem[23] = (TextView) view.findViewById(R.id.textview_productos_encontrados_sem23);
        productosEncontradosSem[24] = (TextView) view.findViewById(R.id.textview_productos_encontrados_sem24);
        productosEncontradosSem[25] = (TextView) view.findViewById(R.id.textview_productos_encontrados_sem25);
        productosEncontradosSem[26] = (TextView) view.findViewById(R.id.textview_productos_encontrados_sem26);

        productosEvaluadosSem[1] = (TextView) view.findViewById(R.id.textview_productos_evaluados_sem01);
        productosEvaluadosSem[2] = (TextView) view.findViewById(R.id.textview_productos_evaluados_sem02);
        productosEvaluadosSem[3] = (TextView) view.findViewById(R.id.textview_productos_evaluados_sem03);
        productosEvaluadosSem[4] = (TextView) view.findViewById(R.id.textview_productos_evaluados_sem04);
        productosEvaluadosSem[5] = (TextView) view.findViewById(R.id.textview_productos_evaluados_sem05);
        productosEvaluadosSem[6] = (TextView) view.findViewById(R.id.textview_productos_evaluados_sem06);
        productosEvaluadosSem[7] = (TextView) view.findViewById(R.id.textview_productos_evaluados_sem07);
        productosEvaluadosSem[8] = (TextView) view.findViewById(R.id.textview_productos_evaluados_sem08);
        productosEvaluadosSem[9] = (TextView) view.findViewById(R.id.textview_productos_evaluados_sem09);
        productosEvaluadosSem[10] = (TextView) view.findViewById(R.id.textview_productos_evaluados_sem10);
        productosEvaluadosSem[11] = (TextView) view.findViewById(R.id.textview_productos_evaluados_sem11);
        productosEvaluadosSem[12] = (TextView) view.findViewById(R.id.textview_productos_evaluados_sem12);
        productosEvaluadosSem[13] = (TextView) view.findViewById(R.id.textview_productos_evaluados_sem13);
        productosEvaluadosSem[14] = (TextView) view.findViewById(R.id.textview_productos_evaluados_sem14);
        productosEvaluadosSem[15] = (TextView) view.findViewById(R.id.textview_productos_evaluados_sem15);
        productosEvaluadosSem[16] = (TextView) view.findViewById(R.id.textview_productos_evaluados_sem16);
        productosEvaluadosSem[17] = (TextView) view.findViewById(R.id.textview_productos_evaluados_sem17);
        productosEvaluadosSem[18] = (TextView) view.findViewById(R.id.textview_productos_evaluados_sem18);
        productosEvaluadosSem[19] = (TextView) view.findViewById(R.id.textview_productos_evaluados_sem19);
        productosEvaluadosSem[20] = (TextView) view.findViewById(R.id.textview_productos_evaluados_sem20);
        productosEvaluadosSem[21] = (TextView) view.findViewById(R.id.textview_productos_evaluados_sem21);
        productosEvaluadosSem[22] = (TextView) view.findViewById(R.id.textview_productos_evaluados_sem22);
        productosEvaluadosSem[23] = (TextView) view.findViewById(R.id.textview_productos_evaluados_sem23);
        productosEvaluadosSem[24] = (TextView) view.findViewById(R.id.textview_productos_evaluados_sem24);
        productosEvaluadosSem[25] = (TextView) view.findViewById(R.id.textview_productos_evaluados_sem25);
        productosEvaluadosSem[26] = (TextView) view.findViewById(R.id.textview_productos_evaluados_sem26);

        for(int i=1;i<=26;i++){
            productosExhigidosSem[i].setText(cliente.productosExhigidos);
        }

        //TODO implementar el metodo para obtener los productos encontrados, productos evaluados,
        //TODO  lista de productos faltantes y si se uso el comodin
        //TODO  OBTENER el logro del mes(solo a fin de mes)
        return view;
    }

}
