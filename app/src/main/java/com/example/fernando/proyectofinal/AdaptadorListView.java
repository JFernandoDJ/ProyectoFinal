package com.example.fernando.proyectofinal;

        import android.content.Context;
        import android.os.Build;
        import android.support.annotation.RequiresApi;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.BaseAdapter;
        import android.widget.ImageView;
        import android.widget.TextView;
        import android.widget.Toast;

        import com.example.fernando.proyectofinal.bd.Nota;

        import java.util.List;

public class AdaptadorListView extends BaseAdapter {

    Context context;
    List<Nota> listaDatos;

    public AdaptadorListView(Context context, List<Nota> listaDatos) {
        this.context = context;
        this.listaDatos = listaDatos;
    }

    @Override
    public int getCount() {
        return listaDatos.size();
    }

    @Override
    public Object getItem(int i) {
        return listaDatos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return listaDatos.get(i).getId();
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View vista = view;

        LayoutInflater inflater = LayoutInflater.from(context);
        vista = inflater.inflate(R.layout.item_list_view,null);
        ImageView iv = vista.findViewById(R.id.img_icon);
        TextView txt = vista.findViewById(R.id.txtT);
        txt.setText(listaDatos.get(i).getTitulo());
        try {
            if (listaDatos.get(i).isRecordatorio()) {
                iv.setBackground(viewGroup.getContext().getResources().getDrawable(R.drawable.notificacion));
            } else {
                iv.setBackground(viewGroup.getContext().getResources().getDrawable(R.drawable.notas_icon));
            }
        }catch (Exception e){
            Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
        }

        return vista;
    }
}
