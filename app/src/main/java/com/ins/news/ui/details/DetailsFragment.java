package com.ins.news.ui.details;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ins.news.R;
import com.ins.news.databinding.FragmentDetailsBinding;
import com.ins.news.model.Article;
import com.squareup.picasso.Picasso;

public class DetailsFragment extends Fragment {

    private FragmentDetailsBinding binding;

    public DetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentDetailsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Article article = DetailsFragmentArgs.fromBundle(getArguments()).getArticle();
        binding.detailsTitleTextView.setText(article.title);
        binding.detailsAuthorTextView.setText(article.author);
        binding.detailsDateTextView.setText(article.publishedAt);
        binding.detailsDescriptionTextView.setText(article.description);
        binding.detailsContentTextView.setText(article.content);
        Picasso.get().load(article.urlToImage).into(binding.detailsImageView);
    }

}