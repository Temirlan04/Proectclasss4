package kg.geektech.proectclasss38.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import kg.geektech.proectclasss38.OnItemClickListener;
import kg.geektech.proectclasss38.R;
import kg.geektech.proectclasss38.databinding.ItemNewsBinding;
import kg.geektech.proectclasss38.models.News;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private ArrayList<News> list;

    private OnItemClickListener onItemClickListener;

    public NewsAdapter(Context context) {
        list = new ArrayList<>();
    }

    @NonNull
    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       return new ViewHolder(ItemNewsBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull NewsAdapter.ViewHolder holder, int position) {
        holder.bind(list.get(position));
    }

    public void removelist(int position) {
        list.remove(position);
    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    public void addItem(News news) {
        list.add(0, news);
        notifyItemInserted(0);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ItemNewsBinding binding;
        private Context context;
        public ViewHolder(ItemNewsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            binding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onClick(getAdapterPosition());
                }
            });
            binding.getRoot().setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    onItemClickListener.onLongClick(getAdapterPosition());
                    return true;
                }
            });
        }

        public void bind(News news) {
            binding.textTitle.setText(news.getTitle());
            if (getAdapterPosition() % 2 == 1) {
                itemView.setBackgroundResource(R.color.black);
                binding.textTitle.setBackgroundResource(R.color.white);
            }

        }
    }
}

