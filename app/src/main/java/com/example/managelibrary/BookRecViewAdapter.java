package com.example.managelibrary;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.TransitionManager;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class BookRecViewAdapter extends RecyclerView.Adapter<BookRecViewAdapter.ViewHolder>{

    private static final String TAG = "BookRecViewAdapter";

    public static final String BOOK_ID_KEY = "bookId";

    private ArrayList<Book> books=new ArrayList<>();
    private Context mContext;
    private String parentActivity;

    public BookRecViewAdapter(Context mContext, String parentActivity) {
        this.mContext = mContext;
        this.parentActivity = parentActivity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_book,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: called");
        holder.txtName.setText(books.get(position).getName());
        Glide.with(mContext)
                .asBitmap()
                .load(books.get(position).getImageUrl())
                .into(holder.imgBook);
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext,BookActivity.class);
                intent.putExtra(BOOK_ID_KEY,books.get(position).getId());
                mContext.startActivity(intent);
            }
        });
        holder.txtAuthor.setText(books.get(position).getAuthor());
        holder.txtShotDescription.setText(books.get(position).getShortDesc());

        if (books.get(position).isExpanded()){
            TransitionManager.beginDelayedTransition(holder.parent);
            holder.expandedRelativeLayout.setVisibility(View.VISIBLE);
            holder.imgDownArrow.setVisibility(View.GONE);

            if (parentActivity.equals("allBooks")){
                holder.textViewDelete.setVisibility(View.GONE);
            } else if (parentActivity.equals("alreadyRead")){
                holder.textViewDelete.setVisibility(View.VISIBLE);
                holder.textViewDelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                        builder.setMessage("Are you sure you want to delete this book "+books.get(position).getName()+"?");
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (Utils.getInstance().removeFromAlreadyRead(books.get(position))){
                                    Toast.makeText(mContext, "Book removed", Toast.LENGTH_SHORT).show();
                                    notifyDataSetChanged();
                                }else{
                                    Toast.makeText(mContext, "Something wrong happen ,Please try again", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                        builder.create().show();
                    }
                });
            }else if (parentActivity.equals("currentlyReading")){
                holder.textViewDelete.setVisibility(View.VISIBLE);
                holder.textViewDelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                        builder.setMessage("Are you sure you want to delete this book "+books.get(position).getName()+"?");
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (Utils.getInstance().removeFromCurrentlyReading(books.get(position))){
                                    Toast.makeText(mContext, "Book removed", Toast.LENGTH_SHORT).show();
                                    notifyDataSetChanged();
                                }else{
                                    Toast.makeText(mContext, "Something wrong happen ,Please try again", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                        builder.create().show();
                    }
                });
            }else if (parentActivity.equals("wantToRead")){
                holder.textViewDelete.setVisibility(View.VISIBLE);
                holder.textViewDelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                        builder.setMessage("Are you sure you want to delete this book "+books.get(position).getName()+"?");
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (Utils.getInstance().removeFromWantToRead(books.get(position))){
                                    Toast.makeText(mContext, "Book removed", Toast.LENGTH_SHORT).show();
                                    notifyDataSetChanged();
                                }else{
                                    Toast.makeText(mContext, "Something wrong happen ,Please try again", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                        builder.create().show();
                    }
                });
            }else {
                holder.textViewDelete.setVisibility(View.VISIBLE);
                holder.textViewDelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                        builder.setMessage("Are you sure you want to delete this book "+books.get(position).getName()+"?");
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (Utils.getInstance().removeFromFavorite(books.get(position))){
                                    Toast.makeText(mContext, "Book removed", Toast.LENGTH_SHORT).show();
                                    notifyDataSetChanged();
                                }else{
                                    Toast.makeText(mContext, "Something wrong happen ,Please try again", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                        builder.create().show();
                    }
                });
            }
        }else {
            TransitionManager.beginDelayedTransition(holder.parent);
            holder.expandedRelativeLayout.setVisibility(View.GONE);
            holder.imgDownArrow.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private CardView parent;
        private ImageView imgBook;
        private TextView txtName;
        private ImageView imgDownArrow,imgupArrow;
        private RelativeLayout expandedRelativeLayout;
        private TextView txtAuthor,txtShotDescription;

        private TextView textViewDelete;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            parent=itemView.findViewById(R.id.parent);
            imgBook=itemView.findViewById(R.id.imgBook);
            txtName=itemView.findViewById(R.id.txtBookName);


            imgDownArrow =itemView.findViewById(R.id.imgDownArrow);
            imgupArrow=itemView.findViewById(R.id.imgUpArrow);
            expandedRelativeLayout=itemView.findViewById(R.id.expandedRelativeLayout);
            txtAuthor=itemView.findViewById(R.id.txtAuthorName);
            txtShotDescription=itemView.findViewById(R.id.txtShortDesc);
            textViewDelete=itemView.findViewById(R.id.txtViewDelete);

            imgDownArrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Book book = books.get(getAdapterPosition());
                    book.setExpanded(!book.isExpanded());
                    notifyItemChanged(getAdapterPosition());
                }
            });

            imgupArrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Book book = books.get(getAdapterPosition());
                    book.setExpanded(!book.isExpanded());
                    notifyItemChanged(getAdapterPosition());
                }
            });

        }
    }
}
