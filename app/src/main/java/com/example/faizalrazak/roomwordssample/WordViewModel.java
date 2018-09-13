package com.example.faizalrazak.roomwordssample;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

public class WordViewModel extends AndroidViewModel {

    private WordRepository mWordRepository;
    private LiveData<List<Word>> mAllWords;

    public WordViewModel(@NonNull Application application) {
        super(application);

        mWordRepository = new WordRepository(application);
        mAllWords = mWordRepository.getAllWords();
    }

    LiveData<List<Word>> getmAllWords(){
        return mAllWords;
    }

    public void insert(Word word){
        mWordRepository.insert(word);
    }

    public void deleteAll(){
        mWordRepository.deleteAll();
    }
}
