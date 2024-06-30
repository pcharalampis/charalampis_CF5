function toggleArticleContent(articleId, event) {
    event.preventDefault();
    var content = document.getElementById(articleId + '-content');
    var readMoreBtn = document.getElementById(articleId + '-read-more');
    var showLessBtn = document.getElementById(articleId + '-show-less');
    
    if (content.style.display === 'none') {
        content.style.display = 'block';
        readMoreBtn.style.display = 'none';
        showLessBtn.style.display = 'inline-block';
    } else {
        content.style.display = 'none';
        readMoreBtn.style.display = 'inline-block';
        showLessBtn.style.display = 'none';
    }
}