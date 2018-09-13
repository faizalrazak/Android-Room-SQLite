package com.example.faizalrazak.roomwordssample;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class WordRepository {

    private WordDao mWordDao;
    private LiveData<List<Word>> mAllWords;

    public WordRepository(Application application) {

        WordRoomDatabase db = WordRoomDatabase.getDatabase(application);
        mWordDao = db.wordDao();
        mAllWords = mWordDao.getAllWords();
    }

    LiveData<List<Word>> getAllWords(){
        return mAllWords;
    }

    public void insert(Word word){
        new insertAsynctask(mWordDao).execute(word);
    }

    public void deleteAll(){
        new deleteAllAsyncTask(mWordDao).execute();
    }

    //3 paramaters for AsyncTask <what sent to task doInBackground() , data type of progress unit onProgressUpdate(), result delivered onPostExecute()>
    //parameters 1 Word and 2 Void bcs, Word is sent, no progress and no retrieve
    private static class insertAsynctask extends AsyncTask<Word, Void, Void>{

        private WordDao mAsyncTaskDao;

        public insertAsynctask(WordDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(Word... words) {
            mAsyncTaskDao.insert(words[0]);
            return null;
        }
    }

    //3 paramaters for AsyncTask <what sent to task doInBackground() , data type of progress unit onProgressUpdate(), result delivered onPostExecute()>
    //all parameters Void bcs nothing to sent, no progress and no retrieve
    private static class deleteAllAsyncTask extends AsyncTask<Void, Void, Void>{

        private WordDao mAsyncTaskDao;

        public deleteAllAsyncTask(WordDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            mAsyncTaskDao.deleteAll();
            return null;
        }
    }
}
