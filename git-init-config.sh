#!/bin/sh
#Repository root path
repository_path=`git rev-parse --show-toplevel`
#local hook paths
hook_filename='commit-msg'
local_git_hook_dir=$repository_path'/.git/hooks'
local_hook_file_path=$local_git_hook_dir'/'$hook_filename
#Path to commit-checker script
custom_hook_file='commit-msg'
custom_hook_path=$repository_path'/git_hooks/'$custom_hook_file
#Creating symlink between local hook and custom hook
`ln -s -f $custom_hook_path $local_hook_file_path`
`chmod +x $local_hook_file_path`
