package kg.geektech.proectclasss38.ui.board;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.RecyclerView;

import kg.geektech.proectclasss38.R;

public class BoardAdapter extends RecyclerView.Adapter<BoardAdapter.ViewHolder> {

    private String[] titles = new String[] {"Салам", "Привет", "Hello"};
    private  NavController navController;

    public BoardAdapter(NavController navController) {
        this.navController = navController;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_board, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private Button btnStart;
        private TextView textTitle;
        private Button btnSkip;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textTitle = itemView.findViewById(R.id.textTitle);
            btnStart = itemView.findViewById(R.id.btnStart);
            btnSkip = itemView.findViewById(R.id.btnSkip);
            btnStart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    navController.navigateUp();

                }
            });
            btnSkip.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    navController.navigateUp();
                }
            });


        }

        public void bind(int position) {
            textTitle.setText(titles[position]);
            if (position == titles.length -1){
              btnStart.setVisibility(View.VISIBLE);
            }else {
                btnStart.setVisibility(View.INVISIBLE);
            }


        }
    }
}
