package com.example.recycleview;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {
    private List<Book> bookList;
    private Context context;

    public BookAdapter() {
    }

    /**Contructor*/
    public BookAdapter(List<Book> bookList, Context context) {
        this.bookList = bookList;
        this.context = context;
    }

    /** Create ViewHolder*/
    public class BookViewHolder extends  RecyclerView.ViewHolder {
        private TextView title;
        private TextView author;
        private TextView price;
        private Button Chitiet;

        public BookViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            author = (TextView) itemView.findViewById(R.id.author);
            price = (TextView) itemView.findViewById(R.id.price);
            Chitiet=(Button)itemView.findViewById(R.id.btnXoa);
            
            Chitiet.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(v.getContext(),author.getText(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
    @Override
    public BookViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        /** Get layout */
        View view = LayoutInflater.from(context)
                .inflate(R.layout.item,parent,false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BookViewHolder holder, final int position) {
        /** Set Value*/
        final Book book = bookList.get(position);
        holder.title.setText(book.getTitle());
        holder.author.setText(book.getAuthor());
        holder.price.setText(book.getPrice());
        holder.Chitiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertDialog();
                //bookList.remove(position);
               // notifyDataSetChanged();
            }
        });
        /*Sự kiện click vào item*/
    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }
    public void showAlertDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("ThangCoder.Com");
        builder.setMessage("Bạn có muốn xóa không?");
        builder.setCancelable(false);
        builder.setPositiveButton("Quay Lại", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(context, "Không thoát được", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("Đăng xuất", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }
}
