package com.example.faizalrazak.roomwordssample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {

    private final LayoutInflater inflater;
    List<Word> mWord;

    public WordListAdapter(Context context) {
     inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.recyclerview_item, parent, false);
        return new WordViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        if(mWord != null){
            holder.wordtextView.setText(mWord.get(position).getWord());
        }else {
            holder.wordtextView.setText("No Words");
        }
    }

    @Override
    public int getItemCount() {
        if (mWord != null)
        return mWord.size();
        else return 0;
    }

    void setmWords(List<Word> words){
        this.mWord = words;
        notifyDataSetChanged();
    }

    class WordViewHolder extends RecyclerView.ViewHolder{

        TextView wordtextView;

        public WordViewHolder(View itemView) {
            super(itemView);

            wordtextView = itemView.findViewById(R.id.textview);
        }
    }
}
