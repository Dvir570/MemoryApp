package memory.Memoryapp.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import de.hdodenhof.circleimageview.CircleImageView;
import memory.Memoryapp.Object.Memory;
import memory.Memoryapp.Object.User;
import memory.Memoryapp.R;

public class MemoryAdapter extends RecyclerView.Adapter<MemoryAdapter.MemoryViewHolder>{
    private Context mContext;
    private DatabaseReference mData;
    private List<Memory> memoryList;

    public MemoryAdapter(Context mContext, List<Memory> memoryList) {
        this.mContext = mContext;
        this.memoryList = memoryList;
    }

    @NonNull
    @Override
    public MemoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.memory_item, null);
        MemoryAdapter.MemoryViewHolder holder = new MemoryAdapter.MemoryViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MemoryViewHolder memoryViewHolder, int i) {
        Memory memory = memoryList.get(i);
        memoryViewHolder.textView.setText(memory.getMemoryName());
        Picasso.get().load(memory.getImage()).into(memoryViewHolder.imageView);
        memoryViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MemoryViewHolder extends RecyclerView.ViewHolder {
       private ImageView imageView;
       private TextView textView;

        public MemoryViewHolder(@NonNull View itemView) {
          super(itemView);
          imageView = itemView.findViewById(R.id.memory_img_id);
          textView = itemView.findViewById(R.id.memory_title_id);
        }
    }
}
