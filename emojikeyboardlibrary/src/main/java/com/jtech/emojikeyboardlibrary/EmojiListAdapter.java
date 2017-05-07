package com.jtech.emojikeyboardlibrary;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * 表情列表适配器
 * Created by hasee on 2017/5/7.
 */
class EmojiListAdapter extends BaseAdapter {
    private Context context;
    private int[] emojis;

    public EmojiListAdapter(Context contexts, int[] emojis) {
        this.context = contexts;
        this.emojis = emojis;
    }

    @Override
    public int getCount() {
        return emojis.length;
    }

    @Override
    public String getItem(int position) {
        return new String(Character.toChars(emojis[position]));
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (null == convertView) {
            convertView = LayoutInflater.from(context)
                    .inflate(R.layout.view_emoji_item, null, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        //设置表情
        viewHolder.setEmoji(getItem(position));
        return convertView;
    }

    /**
     * 视图持有
     */
    private class ViewHolder {
        private TextView textView;

        public ViewHolder(View itemView) {
            this.textView = (TextView) itemView.findViewById(R.id.textview_emoji_item);
        }

        /**
         * 设置表情
         *
         * @param emoji
         */
        public void setEmoji(String emoji) {
            textView.setText(emoji);
        }
    }
}