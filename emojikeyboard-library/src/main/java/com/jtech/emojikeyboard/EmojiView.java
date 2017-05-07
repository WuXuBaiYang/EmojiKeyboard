package com.jtech.emojikeyboard;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * 表情键盘视图
 * Created by wuxubaiyang on 2017/5/7.
 */

public class EmojiView extends FrameLayout implements View.OnClickListener {
    //指示器的高度dp
    private static final int INDICATOR_DOT_HEIGHT = 4;
    //指示器宽度dp
    private static final int INDICATOR_DOT_WIDTH = 6;
    //指示器已选择的宽度dp
    private static final int INDICATOR_DOT_WIDTH_SELECTED = 18;

    private ViewPager viewPager;
    private TabLayout tabLayout;

    private TextView targetInput;

    public EmojiView(Context context) {
        this(context, null);
    }

    public EmojiView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public EmojiView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    /**
     * 初始化方法
     */
    private void init() {
        //实例化主视图
        View contentView = LayoutInflater.from(getContext())
                .inflate(R.layout.view_emoji_content, this, false);
        //添加主视图
        addView(contentView);
        //设置后退按钮点击事件
        contentView.findViewById(R.id.imagebutton_emoji_content_backspace)
                .setOnClickListener(this);
        //设置表情页
        viewPager = (ViewPager) contentView.findViewById(R.id.viewpager_emoji_content_pager);
        //设置适配器
        EmojiPagerAdapter emojiPagerAdapter = new EmojiPagerAdapter(getPagerViews());
        viewPager.setAdapter(emojiPagerAdapter);
        //初始化tab
        tabLayout = (TabLayout) contentView.findViewById(R.id.tablayout_emoji_content_title);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.imagebutton_emoji_content_backspace) {
            //后退
            if (null != targetInput) {
                Editable editable = targetInput.getEditableText();
                if (targetInput.getSelectionStart() > 0) {
                    if (targetInput.getSelectionStart() != targetInput.getSelectionEnd()) {
                        editable.delete(targetInput.getSelectionStart(), targetInput.getSelectionEnd());
                    } else {
                        if (isEmojiCharacter(targetInput.getText().charAt(targetInput.getSelectionStart() - 1))) {
                            editable.delete(targetInput.getSelectionStart() - 2, targetInput.getSelectionStart());
                        } else {
                            editable.delete(targetInput.getSelectionStart() - 1, targetInput.getSelectionStart());
                        }
                    }
                }
            }
        }
    }

    /**
     * 与输入框绑定
     *
     * @param targetInput 目标输入框
     */
    public void setupWithEditText(TextView targetInput) {
        this.targetInput = targetInput;
    }

    /**
     * 获取表情页视图
     *
     * @return 返回pager视图集合
     */
    private List<View> getPagerViews() {
        List<View> views = new ArrayList<>();
        List<int[]> emojiList = Emoji.getEmojiList();
        for (int i = 0; i < emojiList.size(); i++) {
            GridView gridView = new GridView(getContext());
            final EmojiListAdapter emojiListAdapter =
                    new EmojiListAdapter(getContext(), emojiList.get(i));
            gridView.setNumColumns(7);
            gridView.setStretchMode(GridView.STRETCH_COLUMN_WIDTH);
            gridView.setAdapter(emojiListAdapter);
            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String emoji = emojiListAdapter.getItem(position);
                    if (null != targetInput) {
                        Editable editable = targetInput.getEditableText();
                        if (targetInput.getSelectionStart() != targetInput.getSelectionEnd()) {
                            editable.delete(targetInput.getSelectionStart(), targetInput.getSelectionEnd());
                        }
                        editable.insert(targetInput.getSelectionStart(), emoji);
                    }
                }
            });
            views.add(gridView);
        }
        return views;
    }

    /**
     * 判断是否为表情
     *
     * @param codePoint codepoint
     * @return 判断是否为表情
     */
    private boolean isEmojiCharacter(char codePoint) {
        return !((codePoint == 0x0) ||
                (codePoint == 0x9) ||
                (codePoint == 0xA) ||
                (codePoint == 0xD) ||
                ((codePoint >= 0x20) && (codePoint <= 0xD7FF)) ||
                ((codePoint >= 0xE000) && (codePoint <= 0xFFFD)) ||
                ((codePoint >= 0x10000) && (codePoint <= 0x10FFFF)));
    }
}