package cn.kiway.mp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.d.lib.slidelayout.SlideLayout;
import com.d.lib.slidelayout.SlideManager;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cn.kiway.mp.R;
import cn.kiway.mp.utils.Utils;

/**
 * Created by Administrator on 2018/8/21.
 */

public class InsPgAdapter extends ArrayAdapter {
    List<File> files;
    InsPgHolder holder;
    private SlideManager manager;

    public InsPgAdapter(@NonNull Context context, File[] files) {
        super(context, -1);
        List<File> list = Arrays.asList(files);
        this.files = new ArrayList(list);
        manager = new SlideManager();
    }

    @Override
    public int getCount() {
        return files.size();
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.list_file_item, null);
            holder = new InsPgHolder();
            holder.icon = (ImageView) view.findViewById(R.id.icon);
            holder.name = (TextView) view.findViewById(R.id.name);
            holder.tv_delete = (TextView) view.findViewById(R.id.tv_delete);
            holder.slideLayout = (SlideLayout) view.findViewById(R.id.sl_slide);
            view.setTag(holder);
        } else {
            holder = (InsPgHolder) view.getTag();
        }
        final File file = files.get(position);
        holder.name.setText(file.getName());
        holder.icon.setImageDrawable(Utils.getApkIcon(getContext(), file.getPath()));
        holder.tv_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (file.exists())
                    file.delete();
                files.remove(position);
                manager.closeAll(holder.slideLayout);
                holder.slideLayout.setOpen(false,false);
                notifyDataSetChanged();
            }
        });
        holder.slideLayout.setOnStateChangeListener(new SlideLayout.OnStateChangeListener() {
            @Override
            public void onChange(SlideLayout layout, boolean isOpen) {
                manager.onChange(layout, isOpen);
            }
            @Override
            public boolean closeAll(SlideLayout layout) {
                return manager.closeAll(layout);
            }
        });
        return view;
    }

    class InsPgHolder {
        ImageView icon;
        TextView name;
        TextView tv_delete;
        SlideLayout slideLayout;
    }
}
